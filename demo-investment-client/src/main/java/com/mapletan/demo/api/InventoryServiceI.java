package com.mapletan.demo.api;

import com.mapletan.demo.dto.command.inventory.InventoryUpdateCmd;
import com.mapletan.demo.dto.command.inventory.InventoryVerifyCmd;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
public interface InventoryServiceI {

    boolean securityInventoryVerify(InventoryVerifyCmd cmd);

    void updateInventory(InventoryUpdateCmd cmd);
}
