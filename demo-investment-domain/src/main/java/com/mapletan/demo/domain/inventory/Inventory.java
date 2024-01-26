package com.mapletan.demo.domain.inventory;

import com.alibaba.cola.domain.Entity;
import com.mapletan.demo.domain.BaseDO;
import com.mapletan.demo.domain.inventory.gateway.InventoryGateway;
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

    public boolean freezeInventory(InventoryGateway gateway){
//        return gateway.freezeInventory(this);
        return false;
    }

    public boolean updateInventory(InventoryGateway gateway){
        return gateway.updateInventory(this);
    }


}
