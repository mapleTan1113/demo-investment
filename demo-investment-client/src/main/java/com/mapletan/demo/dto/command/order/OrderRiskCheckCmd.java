package com.mapletan.demo.dto.command.order;

import com.alibaba.cola.dto.Command;
import com.mapletan.demo.dto.data.OrderDTO;
import lombok.Data;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/
@Data
public class OrderRiskCheckCmd extends Command {

    private String orderId;

    private OrderDTO orderDTO;
}
