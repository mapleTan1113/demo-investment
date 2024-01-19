package com.mapletan.demo.dto.data;

import com.alibaba.cola.dto.DTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class OrderDTO extends DTO {

    @NotNull
    private String orderId;

    @NotNull
    private String portfolioId;

    @NotNull
    private String accountId;

    private List<OrderDetailDTO> increasePositionList;

    private List<OrderDetailDTO> decreasePositionList;

    private Integer orderState;
}
