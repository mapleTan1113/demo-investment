package com.mapletan.demo.utils;

import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.data.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
@Mapper(componentModel = "spring")
public interface OrderConvertor {

    OrderConvertor INSTANCE = Mappers.getMapper(OrderConvertor.class);

    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDTO);


}
