package com.mapletan.demo.config;

import com.mapletan.demo.dto.data.AccountDTO;
import com.mapletan.demo.dto.data.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

@Mapper(componentModel = "spring")
public interface AccountConvertor {
    AccountConvertor INSTANCE = Mappers.getMapper(AccountConvertor.class);
    AccountDTO toDTO(OrderDTO orderDTO);
}
