package com.mapletan.demo.domain.account;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/19
 **/
@Data
@Entity
public class Account {

    private String accountId;

    private BigDecimal totalCapital;

    private BigDecimal availableCapital;

    private BigDecimal frozenCapital;

    private BigDecimal settleCapital;

    public void freezeCapital(){

    }

    public void updateCapital(){
        //
    }

    void releaseCapital(){
        // 释放冻结，不做
    }
}
