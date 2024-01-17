package com.mapletan.demo.order.executor;

import com.alibaba.cola.dto.Response;
import com.mapletan.demo.domain.order.Order;
import com.mapletan.demo.dto.command.order.OrderRiskCheckCmd;
import com.mapletan.demo.utils.OrderConvertor;
import org.springframework.stereotype.Component;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Component
public class OrderRiskCheckCmdExe {

    public boolean execute(OrderRiskCheckCmd cmd) {
        Order order = OrderConvertor.INSTANCE.toEntity(cmd.getOrderDTO());
        return order.riskCheck();
    }
}
