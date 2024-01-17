package com.mapletan.demo.dto.event;

import com.mapletan.demo.dto.data.OrderDTO;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/
public class OrderExecutedEvent extends AbstractEvent{

    @NotNull
    private OrderDTO orderDTO;
}
