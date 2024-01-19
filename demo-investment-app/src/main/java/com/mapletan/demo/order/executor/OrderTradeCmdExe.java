package com.mapletan.demo.order.executor;

import com.alibaba.cola.dto.Response;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.dto.command.order.OrderTradeCmd;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.utils.OrderConvertor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/18
 **/
@Component
public class OrderTradeCmdExe {

    @Resource
    private OrderGateway orderGateway;

    public Response execute(OrderDTO orderDTO) {
        Order order = OrderConvertor.INSTANCE.toEntity(orderDTO);
        order.trade(orderGateway);
        order.updateState(orderGateway);
        return Response.buildSuccess();
    }
}
