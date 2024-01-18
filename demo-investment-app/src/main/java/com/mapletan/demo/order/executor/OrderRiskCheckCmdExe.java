package com.mapletan.demo.order.executor;

import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.dto.command.order.OrderRiskCheckCmd;
import com.mapletan.demo.utils.OrderConvertor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Component
public class OrderRiskCheckCmdExe {

    @Resource
    OrderGateway orderGateway;

    public void execute(OrderRiskCheckCmd cmd) {
        Order order = OrderConvertor.INSTANCE.toEntity(cmd.getOrderDTO());
        order.riskCheck(orderGateway);
    }
}
