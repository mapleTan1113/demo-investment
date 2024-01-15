package com.mapletan.demo.listener;

import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.api.AccountServiceI;
import com.mapletan.demo.api.InventoryServiceI;
import com.mapletan.demo.common.DomainEventPublisher;
import com.mapletan.demo.config.AccountConvertor;
import com.mapletan.demo.config.InventoryConvertor;
import com.mapletan.demo.dto.command.account.AccountVerifyCmd;
import com.mapletan.demo.dto.command.inventory.InventoryVerifyCmd;
import com.mapletan.demo.dto.data.AccountDTO;
import com.mapletan.demo.dto.data.InventoryDTO;
import com.mapletan.demo.dto.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Slf4j
@Component
public class OrderCreatedListener {

    @Resource
    private InventoryServiceI inventoryService;

    @Resource
    private AccountServiceI accountService;

    @Subscribe
    public void listen(OrderCreatedEvent event) {

        log.info(event.toString());
        AccountVerifyCmd accountVerifyCmd = new AccountVerifyCmd();
        InventoryVerifyCmd inventoryVerifyCmd = new InventoryVerifyCmd();
        accountVerifyCmd.setAccountDTO(AccountConvertor.INSTANCE.toDTO(event.getOrderDTO()));
        inventoryVerifyCmd.setInventoryDTO(InventoryConvertor.INSTANCE.toDTO(event.getOrderDTO()));

        boolean capitalVerifyResult = accountService.capitalVerify(accountVerifyCmd);
        boolean securityInventoryVerifyResult = inventoryService.securityInventoryVerify(inventoryVerifyCmd);
        boolean riskCheckResult = riskCheck();
        if(capitalVerifyResult&&securityInventoryVerifyResult&&riskCheckResult){
            // 发布验资验券成功事件
        }else{
            // 发布失败事件
        }

    }

    boolean riskCheck(){
        log.info("riskCheck success");
        return true;
    }
}
