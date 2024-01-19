package com.mapletan.demo.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.api.AccountServiceI;
import com.mapletan.demo.api.InventoryServiceI;
import com.mapletan.demo.dto.command.account.AccountCapitalUpdateCmd;
import com.mapletan.demo.dto.command.inventory.InventoryUpdateCmd;
import com.mapletan.demo.dto.event.TradeResultRecordedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/19
 **/
@Slf4j
@Component
public class TradeResultRecordedListener {

    @Resource
    private InventoryServiceI inventoryService;

    @Resource
    private AccountServiceI accountService;

    @Resource
    private EventBus eventBus;

    @PostConstruct
    public void register(){
        log.info("singleton event bus register listener instance: "+ TradeResultRecordedListener.class.getName() +" on spring service PostConstruct");
        eventBus.register(this);
    }

    @Subscribe
    public void listenThenUpdateInventory(TradeResultRecordedEvent tradeResultRespondedEvent){
        log.info("listenThenUpdateInventory");
        InventoryUpdateCmd cmd = new InventoryUpdateCmd();
        inventoryService.updateInventory(cmd);
    }

    @Subscribe
    public void listenThenUpdateCapital(TradeResultRecordedEvent tradeResultRespondedEvent){
        log.info("listenThenUpdateCapital");
        AccountCapitalUpdateCmd cmd = new AccountCapitalUpdateCmd();
        accountService.updateCapital(cmd);
    }
}
