package com.mapletan.demo.common;

import com.google.common.eventbus.AsyncEventBus;
import com.mapletan.demo.dto.event.AbstractEvent;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/24
 **/
public class TimestampOrderedEventBus extends AsyncEventBus{

    private final PriorityQueue<AbstractEvent> queue;

    public TimestampOrderedEventBus(Executor executor) {
        super(executor);
        this.queue = new PriorityQueue<>(Comparator.comparing(AbstractEvent::getTimestamp));
    }

    @Override
    public void post(Object event){
        queue.add((AbstractEvent) event);
        while(!queue.isEmpty()){
            AbstractEvent top = queue.poll();
            super.post(top);
        }
    }

}
