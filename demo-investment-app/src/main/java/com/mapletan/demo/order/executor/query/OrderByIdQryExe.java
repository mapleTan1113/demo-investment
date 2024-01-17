package com.mapletan.demo.order.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.query.order.OrderByIdQry;
import com.mapletan.demo.utils.OrderConvertor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Component
public class OrderByIdQryExe {

    @Resource
    private OrderGateway orderGateway;

    public SingleResponse<OrderDTO> execute(OrderByIdQry orderByIdQry) {
        Order order = orderGateway.getByUserId(orderByIdQry.getOrderId());
        return SingleResponse.of(OrderConvertor.INSTANCE.toDTO(order));
    }



}
