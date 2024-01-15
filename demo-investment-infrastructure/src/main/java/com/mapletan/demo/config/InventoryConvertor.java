package com.mapletan.demo.config;

import com.mapletan.demo.dto.data.InventoryDTO;
import com.mapletan.demo.dto.data.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
@Mapper(componentModel = "spring")
public interface InventoryConvertor {
    InventoryConvertor INSTANCE = Mappers.getMapper(InventoryConvertor.class);
    InventoryDTO toDTO(OrderDTO orderDTO);
}
