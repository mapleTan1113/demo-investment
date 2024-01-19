package com.mapletan.demo.web;

import com.alibaba.cola.dto.Response;
import com.mapletan.demo.api.OrderServiceI;
import com.mapletan.demo.dto.command.order.OrderCreateCmd;
import com.mapletan.demo.dto.command.order.OrderTradeCmd;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderServiceI orderService;

    @PostMapping(value = "/submit")
    public Response submit(@RequestBody OrderCreateCmd orderCreateCmd){
        return orderService.submitOrder(orderCreateCmd);
    }

    @PostMapping(value = "/trade")
    public Response trade(@RequestBody OrderTradeCmd cmd){
        return orderService.tradeOrder(cmd);
    }
}
