package com.mapletan.demo.domain.order;

import com.alibaba.cola.domain.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
@NoArgsConstructor
@Entity
public class Order{

    private String orderId;

    private String portfolioId;

    private String accountId;

    private List<OrderDetail> increasePositionList;

    private List<OrderDetail> decreasePositionList;

    private Integer orderState;

}
