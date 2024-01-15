package com.mapletan.demo.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.eventbus.EventBus;
import com.mapletan.demo.listener.OrderCreatedListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author mapleTan
 * @Description
 * @date 2024/01/15
 **/
@Configuration
public class GoogleGuavaCodeCacheConfig {

    @Bean(name = "codeCache")
    public Cache<String, String> codeCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.MINUTES)
                .build();
    }

    @Bean(name = "visitCache")
    public Cache<String, Integer> visitCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(12, TimeUnit.HOURS)
                .build();
    }

    @Bean
    public EventBus eventBusListener(OrderCreatedListener listener){
        EventBus eventBus = new EventBus();
        eventBus.register(listener);
        return eventBus;
    }

}
