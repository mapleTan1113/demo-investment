package com.mapletan.demo.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.api.AccountServiceI;
import com.mapletan.demo.api.InventoryServiceI;
import com.mapletan.demo.dto.event.AccountCapitalVerifiedEvent;
import com.mapletan.demo.dto.event.InventoryVerifiedEvent;
import com.mapletan.demo.utils.AccountConvertor;
import com.mapletan.demo.utils.InventoryConvertor;
import com.mapletan.demo.dto.command.account.AccountCapitalVerifyCmd;
import com.mapletan.demo.dto.command.inventory.InventoryVerifyCmd;
import com.mapletan.demo.dto.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * https://blog.csdn.net/chou_qi/article/details/130327830
 * @date 2024/01/15
 **/

@Slf4j
@Component
public class OrderCreatedListener {

    @Resource
    private InventoryServiceI inventoryService;

    @Resource
    private AccountServiceI accountService;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private EventBus eventBus;

    @PostConstruct
    public void register(){
        log.info("singleton event bus register listener instance: "+ OrderCreatedListener.class.getName() +" on spring service PostConstruct");
        eventBus.register(this);
    }

    @Subscribe
    public void listen(OrderCreatedEvent event) {

        log.info(event.toString());

        AccountCapitalVerifyCmd accountVerifyCmd = new AccountCapitalVerifyCmd();
        InventoryVerifyCmd inventoryVerifyCmd = new InventoryVerifyCmd();
        accountVerifyCmd.setAccountDTO(AccountConvertor.INSTANCE.toDTO(event.getOrderDTO()));
        inventoryVerifyCmd.setInventoryDTO(InventoryConvertor.INSTANCE.toDTO(event.getOrderDTO()));

//        Boolean executeResult = verifyCapitalInventoryInTransaction(accountVerifyCmd, inventoryVerifyCmd);
        Boolean result = verifyCapitalInventoryNormally(accountVerifyCmd, inventoryVerifyCmd);

        // 这段代码里验资验券放到一个事务里同步执行，所以post后执行的验券event就行
        // 如果是异步事件总线的话要对event做持久化，要设置policy去查event的执行结果，会复杂很多
        AccountCapitalVerifiedEvent accountCapitalVerifiedEvent = new AccountCapitalVerifiedEvent();
        InventoryVerifiedEvent inventoryVerifiedEvent = new InventoryVerifiedEvent();

        accountCapitalVerifiedEvent.setOrderId(event.getOrderDTO().getOrderId());
        inventoryVerifiedEvent.setOrderId(event.getOrderDTO().getOrderId());
        inventoryVerifiedEvent.setInventoryVerifySuccess(result ==null ? false : result);

        eventBus.post(inventoryVerifiedEvent);
    }

    private Boolean verifyCapitalInventoryInTransaction(AccountCapitalVerifyCmd accountVerifyCmd, InventoryVerifyCmd inventoryVerifyCmd) {
        return transactionTemplate.execute(status -> {
            try {
                boolean capitalVerifyResult = accountService.capitalVerify(accountVerifyCmd);
                boolean securityInventoryVerifyResult = inventoryService.securityInventoryVerify(inventoryVerifyCmd);

                if (!capitalVerifyResult || !securityInventoryVerifyResult) {
                    status.setRollbackOnly();
                    log.error("验资验券 fail!");
                    return false;
                }
                log.info("验资验券 success!");
                return true;

            } catch (Exception e) {
                // 捕获异常并标记事务为回滚状态
                log.error("验资验券 fail!");
                status.setRollbackOnly();
                return false;
            }
        });
    }

    private Boolean verifyCapitalInventoryNormally(AccountCapitalVerifyCmd accountVerifyCmd, InventoryVerifyCmd inventoryVerifyCmd) {
        try {
            boolean capitalVerifyResult = accountService.capitalVerify(accountVerifyCmd);
            boolean securityInventoryVerifyResult = inventoryService.securityInventoryVerify(inventoryVerifyCmd);
            if (!capitalVerifyResult || !securityInventoryVerifyResult) {
                log.error("验资验券 fail!");
                return false;
            }
            log.info("验资验券 success!");
            return true;
        } catch (Exception e) {
            // 捕获异常并标记事务为回滚状态
            log.error("验资验券 fail!");
            return false;
        }
    }

}
