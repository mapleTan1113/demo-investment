package com.mapletan.demo.order;

import com.google.common.eventbus.EventBus;
import com.mapletan.demo.dto.event.OrderRiskCheckedEvent;
import com.mapletan.demo.dto.event.OrderStateUpdatedEvent;
import com.mapletan.demo.utils.OrderConvertor;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class OrderGatewayImpl implements OrderGateway {

//    @Resource
//    private OrderMapper orderMapper;
//
//    @Resource
//    private OrderDetailMapper orderDetailMapper;

    @Resource
    private EventBus eventBus;

    @Override
    public void create(Order order) {
//        orderMapper.save(order);
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        OrderDTO orderDTO = OrderConvertor.INSTANCE.toDTO(order);
        orderCreatedEvent.setOrderDTO(orderDTO);
        eventBus.post(orderCreatedEvent);
        log.info("order created,id:"+order.toString());
    }

    @Override
    public boolean riskCheck(Order order) {
        OrderRiskCheckedEvent orderRiskCheckedEvent = new OrderRiskCheckedEvent();
        orderRiskCheckedEvent.setOrderId(order.getOrderId());
        orderRiskCheckedEvent.setRiskCheckSuccess(true);
        eventBus.post(orderRiskCheckedEvent);
        return false;
    }

    @Override
    public Order getByUserId(String orderId) {
        return null;
    }

    @Override
    public void updateState(Order order) {
        // mapper.update

        //
        OrderStateUpdatedEvent orderStateUpdatedEvent = new OrderStateUpdatedEvent();
    }
}
