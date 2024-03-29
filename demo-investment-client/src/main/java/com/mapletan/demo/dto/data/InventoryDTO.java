package com.mapletan.demo.dto.data;

import com.alibaba.cola.dto.DTO;
import lombok.Data;

import java.util.List;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class InventoryDTO extends DTO {

    private String orderId;

    private String portfolioId;

    private List<OrderDetailDTO> decreasePositionList;

}
