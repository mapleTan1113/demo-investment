package com.mapletan.demo.inventory;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mapletan.demo.api.InventoryServiceI;
import com.mapletan.demo.database.InventoryMapper;
import com.mapletan.demo.database.dataobject.InventoryDO;
import com.mapletan.demo.domain.inventory.Inventory;
import com.mapletan.demo.domain.inventory.gateway.InventoryGateway;
import com.mapletan.demo.dto.command.inventory.InventoryUpdateCmd;
import com.mapletan.demo.dto.command.inventory.InventoryVerifyCmd;
import com.mapletan.demo.dto.data.InventoryDTO;
import com.mapletan.demo.dto.data.OrderDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Service
@CatchAndLog
@Slf4j
public class InventoryServiceImpl implements InventoryServiceI {

    @Resource
    private InventoryMapper inventoryMapper;

    @Resource
    private InventoryGateway inventoryGateway;

    @Override
    @Transactional
    // TODO:乐观锁版本号机制与重试
    public boolean securityInventoryVerify(InventoryVerifyCmd cmd) {
        try {
            String portfolioId = cmd.getInventoryDTO().getPortfolioId();
            List<OrderDetailDTO> decreasePositionList = cmd.getInventoryDTO().getDecreasePositionList();
            for (OrderDetailDTO orderDetailDTO: decreasePositionList) {
                String secId = orderDetailDTO.getSecId();
                Integer quantityToFreeze = orderDetailDTO.getQuantity();
                InventoryDO currentInventory = inventoryMapper.selectOne(new UpdateWrapper<InventoryDO>()
                        .eq("portfolio_id",portfolioId).eq("sec_id", secId));
                if (currentInventory == null || currentInventory.getHoldingQuantity() < quantityToFreeze) {
                    // 库存不足，扣减失败
                    throw new RuntimeException("Reduce operation failed: Record not found or insufficient quantity.");
                }
                // 执行扣减操作
                Integer oldHoldingQuantity = currentInventory.getHoldingQuantity();
                Integer oldFrozenHoldingQuantity = currentInventory.getFrozenHoldingQuantity();
                Integer newHoldingQuantity = currentInventory.getHoldingQuantity() - quantityToFreeze;
                Integer newFrozenHoldingQuantity= currentInventory.getFrozenHoldingQuantity() + quantityToFreeze;
                currentInventory.setHoldingQuantity(newHoldingQuantity);
                currentInventory.setFrozenHoldingQuantity(newFrozenHoldingQuantity);

                // 乐观锁,无重试
                int updateCount = inventoryMapper.update(currentInventory,
                        new UpdateWrapper<InventoryDO>()
                                .eq("portfolio_id",portfolioId)
                                .eq("sec_id", secId)
                                .eq("holding_quantity", oldHoldingQuantity)
                                .eq("frozen_holding_quantity",oldFrozenHoldingQuantity)
                                );

                if (updateCount != 1) {
                    // 更新失败，可能是由于版本冲突，回滚整个事务
                    throw new RuntimeException("Reduce operation failed: Update failed due to version conflict.");
                }
            }

            log.info("securityInventoryVerify success");
            return true;
        }catch (Exception e){
            log.error("securityInventoryVerify failed: " + e.getMessage());
            return false;
        }


    }

    @Override
    public void updateInventory(InventoryUpdateCmd cmd) {

    }
}
