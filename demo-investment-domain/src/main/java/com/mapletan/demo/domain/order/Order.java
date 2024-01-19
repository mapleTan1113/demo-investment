package com.mapletan.demo.domain.order;

import com.alibaba.cola.domain.Entity;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
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

    public void create(OrderGateway orderGateway){
        orderGateway.create(this);
    }

    public void withdraw(){

    }

    public void riskCheck(OrderGateway orderGateway){
        orderGateway.riskCheck(this);
    }

    public void updateState(OrderGateway orderGateway){
        orderGateway.update(this);
    }

    public void trade(OrderGateway orderGateway){
        orderGateway.trade(this);
    }

}
