package com.mapletan.demo.order.executor;

import com.alibaba.cola.dto.Response;
import com.mapletan.demo.domain.order.OrderDetail;
import com.mapletan.demo.domain.order.gateway.OrderDetailGateway;
import com.mapletan.demo.utils.OrderConvertor;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.utils.OrderDetailConvertor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private OrderDetailGateway orderDetailGateway;


    @Transactional(rollbackFor = Exception.class)
    public Response execute(OrderCreateCmd cmd) {
        OrderDTO orderDTO = cmd.getOrderDTO();

        if (emptyParamValidation(orderDTO)){
            return Response.buildFailure("参数错误","参数错误");
        }

        String orderId = orderDTO.getOrderId();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList
                .addAll(
                        orderDTO.getDecreasePositionList()
                                .stream()
                                .map(OrderDetailConvertor.INSTANCE::toEntity)
                                .peek(orderDetail -> orderDetail.setOrderId(orderId)
                ).collect(Collectors.toList()));

        orderDetailList
                .addAll(
                        orderDTO.getIncreasePositionList()
                                .stream()
                                .map(OrderDetailConvertor.INSTANCE::toEntity)
                                .peek(orderDetail -> orderDetail.setOrderId(orderId)
                ).collect(Collectors.toList()));


        orderDetailGateway.createBatch(orderDetailList);
        Order order = OrderConvertor.INSTANCE.toEntity(orderDTO);
        order.create(orderGateway);

        return Response.buildSuccess();
    }

    private boolean emptyParamValidation(OrderDTO orderDTO){
        return CollectionUtils.isEmpty(orderDTO.getIncreasePositionList())
                &&CollectionUtils.isEmpty(orderDTO.getDecreasePositionList());
    }
}
