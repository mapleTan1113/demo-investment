package com.mapletan.demo.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
    @Scope("singleton")
    public EventBus createEventBus(){
        return new EventBus();
    }

}
