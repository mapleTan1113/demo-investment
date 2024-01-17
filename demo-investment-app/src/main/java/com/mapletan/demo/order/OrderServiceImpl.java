package com.mapletan.demo.order;

//package by domain, not by duty


import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.order.executor.OrderStateUpdateCmdExe;
import com.mapletan.demo.order.executor.query.OrderByIdQryExe;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;
import com.mapletan.demo.dto.command.order.OrderRiskCheckCmd;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.query.order.OrderByIdQry;
import com.mapletan.demo.order.executor.OrderCreateCmdExe;
import com.mapletan.demo.order.executor.OrderRiskCheckCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class OrderServiceImpl implements OrderServiceI {

    @Resource
    private OrderCreateCmdExe orderCreateCmdExe;

    @Resource
    private OrderByIdQryExe orderByIdQryExe;

    @Resource
    private OrderRiskCheckCmdExe orderRiskCheckCmdExe;

    @Resource
    private OrderStateUpdateCmdExe orderStateUpdateCmdExe;


    @Override
    public Response submitOrder(OrderCreateCmd cmd) {
        return orderCreateCmdExe.execute(cmd);
    }

    @Override
    public boolean riskCheck(OrderRiskCheckCmd cmd) {
        OrderByIdQry orderByIdQry = new OrderByIdQry();
        SingleResponse<OrderDTO> response = getByOrderId(orderByIdQry);
        cmd.setOrderDTO(response.getData());
        return orderRiskCheckCmdExe.execute(cmd);
    }

    @Override
    public void updateState(OrderStateUpdateCmd cmd) {
        orderStateUpdateCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<OrderDTO> getByOrderId(OrderByIdQry orderByIdQry) {
        return orderByIdQryExe.execute(orderByIdQry);
    }
}