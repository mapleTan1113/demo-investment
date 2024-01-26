package com.mapletan.demo.domain.inventory.gateway;

import com.mapletan.demo.domain.inventory.Inventory;
import com.mapletan.demo.dto.data.OrderDetailDTO;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/26
 **/
public interface InventoryGateway {

    boolean freezeInventory(OrderDetailDTO orderDetailDTO, String portfolioId);

    boolean updateInventory(Inventory inventory);
}
