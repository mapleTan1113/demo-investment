package com.mapletan.demo.dto.command.order;

import com.mapletan.demo.dto.data.OrderDTO;
import lombok.Data;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class OrderCreateCmd {

    private OrderDTO orderDTO;
}
