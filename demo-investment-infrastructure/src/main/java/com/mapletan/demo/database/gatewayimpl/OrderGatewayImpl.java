package com.mapletan.demo.database.gatewayimpl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.eventbus.EventBus;
import com.mapletan.demo.database.OrderMapper;
import com.mapletan.demo.database.dataobject.OrderDO;
import com.mapletan.demo.dto.event.OrderRiskCheckedEvent;
import com.mapletan.demo.dto.event.OrderStateUpdatedEvent;
import com.mapletan.demo.dto.event.OrderTradeRequestedEvent;
import com.mapletan.demo.utils.OrderConvertor;
import com.mapletan.demo.domain.order.gateway.OrderGateway;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.event.OrderCreatedEvent;
import com.mapletan.demo.utils.mp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
@Slf4j
public class OrderGatewayImpl extends ServiceImpl<OrderMapper, OrderDO> implements OrderGateway, OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private EventBus eventBus;

    @Override
    public void create(Order order) {
        OrderDO orderDO = OrderConvertor.INSTANCE.toDO(order);
        orderMapper.insert(orderDO);
        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
        OrderDTO orderDTO = OrderConvertor.INSTANCE.toDTO(order);
        orderCreatedEvent.setOrderDTO(orderDTO);
        eventBus.post(orderCreatedEvent);
        log.info("order created,id:"+order.toString());
    }

    @Override
    public void riskCheck(Order order) {
        // 这里应该是风控校验的方法实现，略
        //
        OrderRiskCheckedEvent orderRiskCheckedEvent = new OrderRiskCheckedEvent();
        orderRiskCheckedEvent.setOrderId(order.getOrderId());
        orderRiskCheckedEvent.setRiskCheckSuccess(true);
        eventBus.post(orderRiskCheckedEvent);
        log.info("order RiskChecked,id:"+order.toString());
    }

    @Override
    public Order getByOrderId(String orderId) {

        // only for test
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderState(1);
        order.setAccountId("");
        order.setPortfolioId("");
        order.setDecreasePositionList(new ArrayList<>());
        order.setIncreasePositionList(new ArrayList<>());
        return order;
    }

    @Override
    public void trade(Order order) {
        // send trade
        OrderTradeRequestedEvent orderTradeRequestedEvent = new OrderTradeRequestedEvent();
//        orderTradeRequestedEvent.setOrderDTO(OrderConvertor.INSTANCE.toDTO(order));
        orderTradeRequestedEvent.setOrderDTO(new OrderDTO());
        eventBus.post(orderTradeRequestedEvent);
        log.info("order orderTradeRequested,id:"+order.toString());

    }

    @Override
    public void update(Order order) {
        OrderDO orderDO = OrderConvertor.INSTANCE.toDO(order);

        final UpdateWrapper<OrderDO> wrapper = new UpdateWrapper<>();
        wrapper.eq("order_id",orderDO.getOrderId());
        orderMapper.update(orderDO,wrapper);
        log.info("order update! "+ order.toString());
        OrderStateUpdatedEvent orderStateUpdatedEvent = new OrderStateUpdatedEvent();
    }
}
