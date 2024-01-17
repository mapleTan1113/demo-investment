package com.mapletan.demo.dto.command.inventory;

import com.alibaba.cola.dto.Command;
import com.mapletan.demo.dto.data.InventoryDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
public class InventoryVerifyCmd extends Command {

    @NotNull
    private InventoryDTO inventoryDTO;
}
