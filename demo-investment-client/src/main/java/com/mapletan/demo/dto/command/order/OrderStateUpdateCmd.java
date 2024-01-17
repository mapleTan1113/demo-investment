package com.mapletan.demo.dto.command.order;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/
@Data
public class OrderStateUpdateCmd extends Command {

    private String orderId;

    private Integer orderState;
}
