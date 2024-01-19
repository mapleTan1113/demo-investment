package com.mapletan.demo.inventory;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.mapletan.demo.api.InventoryServiceI;
import com.mapletan.demo.dto.command.inventory.InventoryUpdateCmd;
import com.mapletan.demo.dto.command.inventory.InventoryVerifyCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Service
@CatchAndLog
@Slf4j
public class InventoryServiceImpl implements InventoryServiceI {
    @Override
    public boolean securityInventoryVerify(InventoryVerifyCmd cmd) {
        log.info("securityInventoryVerify success");
        return true;
    }

    @Override
    public void updateInventory(InventoryUpdateCmd cmd) {

    }
}
