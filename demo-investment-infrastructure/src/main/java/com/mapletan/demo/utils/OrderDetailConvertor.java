package com.mapletan.demo.utils;

import com.mapletan.demo.database.dataobject.OrderDetailDO;
import com.mapletan.demo.domain.order.OrderDetail;
import com.mapletan.demo.dto.data.OrderDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
@Mapper(componentModel = "spring")
public interface OrderDetailConvertor {

    OrderDetailConvertor INSTANCE = Mappers.getMapper(OrderDetailConvertor.class);

    OrderDetailDO toDO(OrderDetail orderDetail);

    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);
}
