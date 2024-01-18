package com.mapletan.demo.order.executor;

import com.alibaba.cola.domain.DomainFactory;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.utils.OrderConvertor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Component
public class OrderStateUpdateCmdExe {

    @Resource
    private OrderGateway orderGateway;

    public void execute(OrderStateUpdateCmd cmd) {
        Order order = DomainFactory.create(Order.class);
        order.setOrderId(cmd.getOrderId());
        order.setOrderState(cmd.getOrderState());
        order.updateState(orderGateway);
    }
}
