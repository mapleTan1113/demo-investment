package com.mapletan.demo.api;

import com.alibaba.cola.dto.Response;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

public interface OrderServiceI {
    Response submitOrder(OrderCreateCmd cmd);
}
