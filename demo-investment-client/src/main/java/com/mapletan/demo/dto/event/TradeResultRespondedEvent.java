package com.mapletan.demo.dto.event;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/19
 **/

@Data
public class TradeResultRespondedEvent extends AbstractEvent{

    @NotNull
    private String orderId;

    @NotNull
    private boolean tradeResultSuccess;
}
