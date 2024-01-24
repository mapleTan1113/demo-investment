package com.mapletan.demo.dto.event;

import lombok.Data;

import java.time.Instant;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/17
 **/

@Data
public abstract class AbstractEvent {

    private String eventId;

    private String topic;

    private Instant timestamp;

    public void setTimestamp() {
        this.timestamp = Instant.now();
    }

    public AbstractEvent(){
        this.timestamp=Instant.now();
    }
}
