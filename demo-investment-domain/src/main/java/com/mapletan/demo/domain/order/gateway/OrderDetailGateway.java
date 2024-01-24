package com.mapletan.demo.domain.order.gateway;


import com.mapletan.demo.domain.order.OrderDetail;
import com.mapletan.demo.dto.data.OrderDetailDTO;

import java.util.List;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/24
 **/
public interface OrderDetailGateway {
    boolean createBatch(List<OrderDetail> list);
}
