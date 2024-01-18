package com.mapletan.demo.api;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;
import com.mapletan.demo.dto.command.order.OrderRiskCheckCmd;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.query.order.OrderByIdQry;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/

public interface OrderServiceI {
    Response submitOrder(OrderCreateCmd cmd);

    void riskCheck(OrderRiskCheckCmd cmd);

    void updateState(OrderStateUpdateCmd cmd);

    SingleResponse<OrderDTO> getByOrderId(OrderByIdQry qry);

}
