package com.mapletan.demo.domain.order;

import lombok.Getter;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/24
 **/


public enum OrderState {

    CREATED(0,"订单已创建,验资验券中"),
    VERIFIED(1,"订单已验资验券,风控中"),
    RISKCHECKED(2,"订单已风控,可交易"),
    TRADED(3,"订单已交易,等待交易回报中"),
    RECORDED(4,"交易回报已登记,更新持仓与资金数据中"),
    SUCCESS(5,"成功"),
    FAIL(-1,"失败");

    @Getter
    private final int code;

    private String state;

    OrderState(int code,String state){
        this.code=code;
        this.state=state;
    }


}
