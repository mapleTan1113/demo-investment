package com.mapletan.demo.domain.order;

import com.alibaba.cola.domain.Entity;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;
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

    @Resource
    private OrderGateway orderGateway;

    public void create(){
        orderGateway.create(this);
    }

    public void withdraw(){

    }

    public void updateState(){
        orderGateway.updateState(this);
    }

    public void execute(){

    }

    public boolean riskCheck(){
        return orderGateway.riskCheck(this);
    }

}
