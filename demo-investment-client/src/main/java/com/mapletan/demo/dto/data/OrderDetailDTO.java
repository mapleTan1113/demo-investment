package com.mapletan.demo.dto.data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class OrderDetailDTO {

    private String secId;

    private String companyName;

    private Byte direction;

    private Integer quantity;

    private BigDecimal price;

}
