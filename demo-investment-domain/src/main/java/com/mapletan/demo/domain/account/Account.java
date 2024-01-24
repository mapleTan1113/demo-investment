package com.mapletan.demo.domain.account;

import com.alibaba.cola.domain.Entity;
import com.mapletan.demo.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/19
 **/
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Account extends BaseDO {

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
