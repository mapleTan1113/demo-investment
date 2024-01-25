package com.mapletan.demo.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.domain.order.OrderState;
import com.mapletan.demo.dto.command.order.TradeResultRecordCmd;
import com.mapletan.demo.dto.event.TradeResultRespondedEvent;
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
public class TradeResultRespondedListener {


    @Resource
    private OrderServiceI orderService;

    @Resource
    private EventBus eventBus;

    @PostConstruct
    public void register(){
        log.info("singleton event bus register listener instance: "+ TradeResultRespondedListener.class.getName() +" on spring service PostConstruct");
        eventBus.register(this);
    }


    @Subscribe
    public void listenThenRecordResult(TradeResultRespondedEvent tradeResultRespondedEvent){
        log.info("listenThenRecordResult");
        TradeResultRecordCmd cmd = new TradeResultRecordCmd();
        cmd.setOrderId(tradeResultRespondedEvent.getOrderId());
        OrderState orderState = OrderState.convertTradeResultToState(tradeResultRespondedEvent.isTradeResultSuccess());
        cmd.setOrderState(orderState.getCode());
        orderService.recordTradeResult(cmd);
    }


}
