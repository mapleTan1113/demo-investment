package com.mapletan.demo.order.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.google.common.eventbus.EventBus;
import com.mapletan.demo.dto.command.order.OrderStateUpdateCmd;
import com.mapletan.demo.dto.command.order.TradeResultRecordCmd;
import com.mapletan.demo.dto.data.OrderDTO;
import com.mapletan.demo.dto.event.TradeResultRecordedEvent;
import com.mapletan.demo.dto.query.order.OrderByIdQry;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/19
 **/

@Component
public class TradeResultRecordCmdExe {

    @Resource
    private EventBus eventBus;

    public void execute(OrderDTO orderDTO){


        TradeResultRecordedEvent event = new TradeResultRecordedEvent();
        event.setOrderDTO(orderDTO);
        eventBus.post(event);

    }
}
