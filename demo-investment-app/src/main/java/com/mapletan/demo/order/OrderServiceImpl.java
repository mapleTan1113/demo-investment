package com.mapletan.demo.order;

//package by domain, not by duty


import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.google.common.eventbus.EventBus;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.dto.command.order.*;
import com.mapletan.demo.order.executor.*;
import com.mapletan.demo.order.executor.query.OrderByIdQryExe;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.query.order.OrderByIdQry;
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

    @Resource
    private OrderTradeCmdExe orderTradeCmdExe;

    @Resource
    private TradeResultRecordCmdExe tradeResultRecordCmdExe;


    @Override
    public Response submitOrder(OrderCreateCmd cmd) {
        return orderCreateCmdExe.execute(cmd);
    }

    @Override
    public void riskCheck(OrderRiskCheckCmd cmd) {
        OrderByIdQry orderByIdQry = new OrderByIdQry();
        orderByIdQry.setOrderId(cmd.getOrderId());
        SingleResponse<OrderDTO> response = getByOrderId(orderByIdQry);
        cmd.setOrderDTO(response.getData());
        orderRiskCheckCmdExe.execute(cmd);
    }

    @Override
    public void updateState(OrderStateUpdateCmd cmd) {
        orderStateUpdateCmdExe.execute(cmd);
    }

    @Override
    public void recordTradeResult(TradeResultRecordCmd cmd) {

        OrderStateUpdateCmd orderStateUpdateCmd = new OrderStateUpdateCmd();
        orderStateUpdateCmd.setOrderId(cmd.getOrderId());
        orderStateUpdateCmd.setOrderState(cmd.getOrderState());
        orderStateUpdateCmdExe.execute(orderStateUpdateCmd);

        OrderByIdQry orderByIdQry = new OrderByIdQry();
        orderByIdQry.setOrderId(cmd.getOrderId());
        SingleResponse<OrderDTO> response = getByOrderId(orderByIdQry);
        tradeResultRecordCmdExe.execute(response.getData());
    }

    @Override
    public SingleResponse<OrderDTO> getByOrderId(OrderByIdQry orderByIdQry) {
        return orderByIdQryExe.execute(orderByIdQry);
    }

    @Override
    public Response tradeOrder(OrderTradeCmd cmd) {
        OrderByIdQry orderByIdQry = new OrderByIdQry();
        SingleResponse<OrderDTO> response = getByOrderId(orderByIdQry);
        return orderTradeCmdExe.execute(response.getData());
    }
}