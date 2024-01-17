package com.mapletan.demo.order.executor;

import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.utils.OrderConvertor;
import org.springframework.stereotype.Component;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Component
public class OrderStateUpdateCmdExe {
    public void execute(OrderStateUpdateCmd cmd) {
        Order order = new Order();
        order.setOrderId(cmd.getOrderId());
        order.setOrderState(cmd.getOrderState());
        order.updateState();
    }
}
