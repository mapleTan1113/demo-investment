package com.mapletan.demo.database.gatewayimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapletan.demo.database.OrderDetailMapper;
import com.mapletan.demo.database.dataobject.OrderDetailDO;
import com.mapletan.demo.domain.order.OrderDetail;
import com.mapletan.demo.domain.order.gateway.OrderDetailGateway;
import com.mapletan.demo.dto.data.OrderDetailDTO;
import com.mapletan.demo.utils.OrderDetailConvertor;
import com.mapletan.demo.utils.mp.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/24
 **/

@Component
@Slf4j
public class OrderDetailGatewayImpl extends ServiceImpl<OrderDetailMapper, OrderDetailDO> implements OrderDetailService, OrderDetailGateway {


    @Override
    public boolean createBatch(List<OrderDetail> list) {
        List<OrderDetailDO> collect = list.stream().map(OrderDetailConvertor.INSTANCE::toDO).collect(Collectors.toList());
        return saveBatch(collect);
    }
}
