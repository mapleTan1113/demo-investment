package com.mapletan.demo.listener;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.domain.order.OrderState;
import com.mapletan.demo.dto.command.order.OrderRiskCheckCmd;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.dto.event.InventoryVerifiedEvent;
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
public class InventoryVerifiedListener {

    @Resource
    private EventBus eventBus;

    @Resource
    private OrderServiceI orderService;


    @PostConstruct
    public void register(){
        log.info("singleton event bus register listener instance: "+ InventoryVerifiedListener.class.getName() +" on spring service PostConstruct");
        eventBus.register(this);
    }

    @Subscribe
    public void listen(InventoryVerifiedEvent event) {
        log.info(event.toString());
        OrderStateUpdateCmd orderStateUpdateCmd = new OrderStateUpdateCmd();
        orderStateUpdateCmd.setOrderId(event.getOrderId());
        if (!policy(event, orderStateUpdateCmd)) return;

        OrderRiskCheckCmd orderRiskCheckCmd = new OrderRiskCheckCmd();
        orderRiskCheckCmd.setOrderId(event.getOrderId());
        orderService.riskCheck(orderRiskCheckCmd);
    }

    private boolean policy(InventoryVerifiedEvent event, OrderStateUpdateCmd orderStateUpdateCmd) {
        if(!event.isInventoryVerifySuccess()){
            // 更新状态为失败
            orderStateUpdateCmd.setOrderState(OrderState.FAIL.getCode());
            orderService.updateState(orderStateUpdateCmd);
            return false;
        }
        orderStateUpdateCmd.setOrderState(OrderState.VERIFIED.getCode());
        orderService.updateState(orderStateUpdateCmd);
        return true;
    }

}
