package com.mapletan.demo.dto.command.order;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/
@Data
public class OrderStateUpdateCmd extends Command {

    @NotNull
    private String orderId;

    @NotNull
    private Integer orderState;
}
