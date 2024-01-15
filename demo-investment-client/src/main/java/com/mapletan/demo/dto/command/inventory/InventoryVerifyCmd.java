package com.mapletan.demo.dto.command.inventory;

import com.mapletan.demo.dto.data.InventoryDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Data
@NoArgsConstructor
public class InventoryVerifyCmd {

    @NotNull
    private InventoryDTO inventoryDTO;
}
