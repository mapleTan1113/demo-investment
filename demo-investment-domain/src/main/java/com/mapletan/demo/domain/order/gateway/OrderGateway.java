package com.mapletan.demo.domain.order.gateway;

import com.mapletan.demo.domain.order.Order;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
public interface OrderGateway {
    void create(Order order);
    void riskCheck(Order order);
    Order getByUserId(String orderId);

    void updateState(Order order);
}
