package com.mapletan.demo.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.domain.order.OrderState;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.dto.event.OrderRiskCheckedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Slf4j
@Component
public class OrderRiskCheckedListener {

    @Resource
    private EventBus eventBus;

    @Resource
    private OrderServiceI orderService;

    @PostConstruct
    public void register(){
        log.info("singleton event bus register listener instance: "+ OrderRiskCheckedListener.class.getName() +" on spring service PostConstruct");
        eventBus.register(this);
    }

    @Subscribe
    public void listen(OrderRiskCheckedEvent event) {
        log.info(event.toString());
        OrderStateUpdateCmd orderStateUpdateCmd = new OrderStateUpdateCmd();
        orderStateUpdateCmd.setOrderId(event.getOrderId());
        if(!event.isRiskCheckSuccess()){
            // 更新状态为失败
            orderStateUpdateCmd.setOrderState(OrderState.FAIL.getCode());
            orderService.updateState(orderStateUpdateCmd);
            return;
        }
        orderStateUpdateCmd.setOrderState(OrderState.RISKCHECKED.getCode());
        orderService.updateState(orderStateUpdateCmd);

    }
}
