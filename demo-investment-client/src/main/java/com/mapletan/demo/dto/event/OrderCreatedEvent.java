package com.mapletan.demo.dto.event;

import com.mapletan.demo.dto.data.OrderDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class OrderCreatedEvent {
    @NotNull
    private OrderDTO orderDTO;
}
