package com.mapletan.demo.order.executor;

import com.alibaba.cola.domain.DomainFactory;
import com.alibaba.cola.dto.Response;
import com.mapletan.demo.utils.OrderConvertor;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;
import com.mapletan.demo.dto.data.OrderDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * 1.用户有权限才能下单
 * 2.组合存在才能下单
 * 3.证券id在在组合内才能下单
 * event:订单已生成
 * @date 2024/01/15
 **/
@Component
public class OrderCreateCmdExe {

    @Resource
    private OrderGateway orderGateway;

    public Response execute(OrderCreateCmd cmd) {

        if (!paramValidaion(cmd.getOrderDTO())){
            return Response.buildFailure("参数错误","参数错误");
        }
        Order order = OrderConvertor.INSTANCE.toEntity(cmd.getOrderDTO());
        order.create(orderGateway);
        return Response.buildSuccess();
    }

    private boolean paramValidaion(OrderDTO orderDTO){
        return true;
    }
}
