package com.mapletan.demo.common;

import com.google.common.eventbus.EventBus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
@Deprecated
@Component
public class DomainEventPublisher{

    @Resource
    private EventBus eventBus;

    public void publish(Object domainEvent) {
        //eventBus.fire(domainEvent);
        eventBus.post(domainEvent);
    }
}
