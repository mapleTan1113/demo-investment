package com.mapletan.demo.domain.order;

import com.alibaba.cola.domain.Entity;
import com.mapletan.demo.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
@NoArgsConstructor
@Entity
public class OrderDetail extends BaseDO {

    private String orderId;

    private String secId;

    private String companyName;

    private Byte direction;

    private Integer quantity;

    private BigDecimal price;
}
