package com.mapletan.demo.database.gatewayimpl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mapletan.demo.database.InventoryMapper;
import com.mapletan.demo.database.dataobject.InventoryDO;
import com.mapletan.demo.domain.inventory.Inventory;
import com.mapletan.demo.domain.inventory.gateway.InventoryGateway;
import com.mapletan.demo.dto.data.OrderDetailDTO;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/26
 **/
public class InventoryGatewayImpl implements InventoryGateway {

    @Resource
    private InventoryMapper inventoryMapper;

    @Override
    public boolean freezeInventory(OrderDetailDTO orderDetailDTO, String portfolioId) {
        String secId = orderDetailDTO.getSecId();
        Integer quantity = orderDetailDTO.getQuantity();
        InventoryDO currentInventory = inventoryMapper.selectOne(new UpdateWrapper<InventoryDO>()
                .eq("portfolio_id",portfolioId).eq("sec_id", secId));
        if (currentInventory == null || currentInventory.getHoldingQuantity() < quantity) {
            // 库存不足，扣减失败
            return false;
        }
        UpdateWrapper<Inventory> wrapper = new UpdateWrapper<>();
        return true;
    }

    @Override
    public boolean updateInventory(Inventory inventory) {
        UpdateWrapper<Inventory> wrapper = new UpdateWrapper<>();
        return true;
    }
}
