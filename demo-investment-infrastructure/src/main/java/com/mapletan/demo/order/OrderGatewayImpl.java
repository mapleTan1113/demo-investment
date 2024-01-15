package com.mapletan.demo.order;

import com.mapletan.demo.common.DomainEventPublisher;
import com.mapletan.demo.config.OrderConvertor;
import com.mapletan.demo.domain.customer.gateway.OrderGateway;
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
    private DomainEventPublisher domainEventPublisher;

    @Override
    public void create(Order order) {
//        orderMapper.save(order);
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        OrderDTO orderDTO = OrderConvertor.INSTANCE.toDTO(order);
        orderCreatedEvent.setOrderDTO(orderDTO);
        domainEventPublisher.publish(orderCreatedEvent);
        log.info("order created,id:"+order.toString());
    }
}
