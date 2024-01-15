package com.mapletan.demo.dto.data;

import lombok.Data;

import java.util.List;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class AccountDTO {

    private String orderId;

    private String accountId;

    private List<OrderDetailDTO> increasePositionList;
}