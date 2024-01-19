package com.mapletan.demo.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.event.OrderTradeRequestedEvent;
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
public class OrderTradeRequestedListener {

    @Resource
    private EventBus eventBus;

    @PostConstruct
    public void register(){
        log.info("singleton event bus register listener instance: "+ OrderTradeRequestedListener.class.getName() +" on spring service PostConstruct");
        eventBus.register(this);
    }


    @Subscribe
    public void listen(OrderTradeRequestedEvent orderTradeRequestedEvent){


        boolean res = stockExchangeBusiness(orderTradeRequestedEvent.getOrderDTO());

        TradeResultRespondedEvent tradeResultRespondedEvent = new TradeResultRespondedEvent();
        tradeResultRespondedEvent.setOrderId(orderTradeRequestedEvent.getOrderDTO().getOrderId());
        tradeResultRespondedEvent.setTradeResultSuccess(res);

        eventBus.post(tradeResultRespondedEvent);
    }

    private boolean stockExchangeBusiness(OrderDTO orderDTO){

        return true;
    }
}
