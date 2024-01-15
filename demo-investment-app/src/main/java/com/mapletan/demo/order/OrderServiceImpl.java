package com.mapletan.demo.order;

//package by domain, not by duty


import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.Response;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;
import com.mapletan.demo.order.executor.OrderCreateCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class OrderServiceImpl implements OrderServiceI {

    @Resource
    private OrderCreateCmdExe orderCreateCmdExe;

    @Override
    public Response submitOrder(OrderCreateCmd cmd) {
        return orderCreateCmdExe.execute(cmd);
    }
}