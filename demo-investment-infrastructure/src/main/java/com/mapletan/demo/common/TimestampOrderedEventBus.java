package com.mapletan.demo.common;

import com.google.common.eventbus.EventBus;
import com.mapletan.demo.dto.event.AbstractEvent;

import java.time.Instant;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/24
 **/
public class TimestampOrderedEventBus extends EventBus{
    private final EventBus eventBus;
    private final PriorityQueue<AbstractEvent> queue;

    public TimestampOrderedEventBus() {
        this.eventBus = new EventBus();
        this.queue = new PriorityQueue<>(Comparator.comparing(AbstractEvent::getTimestamp));
    }

    @Override
    public void post(Object event){
        queue.add((AbstractEvent) event);
        processQueue();
    }

    private void processQueue() {
        while(!queue.isEmpty()){
            AbstractEvent event = queue.peek();
            Instant now = Instant.now();
            if(event.getTimestamp().isBefore(now)){
                eventBus.post(event);
                queue.poll();
            }else{
                break;
            }
        }
    }
}
