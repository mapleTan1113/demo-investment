package com.mapletan.demo.dto.event;

import lombok.Data;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Data
public class OrderRiskCheckedEvent extends AbstractEvent{

    private String orderId;

    private boolean riskCheckSuccess;

}