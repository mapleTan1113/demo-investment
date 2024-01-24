package com.mapletan.demo.domain.inventory;

import com.alibaba.cola.domain.Entity;
import com.mapletan.demo.domain.BaseDO;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/19
 **/
@Data
@Entity
public class Inventory extends BaseDO {

    private String portfolioId;

    private String secId;

    private Integer holdingQuantity;

    private Integer frozenHoldingQuantity;

    private BigDecimal costPrice;

    public void frozenInventory(){

    }

    public void updateInventory(){

    }
}
