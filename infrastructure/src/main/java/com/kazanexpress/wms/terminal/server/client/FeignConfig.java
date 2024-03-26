package com.kazanexpress.wms.terminal.server.client;

import feign.Logger;
import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor basicAuthRequestInterceptor(@Value("${wms.nexus.username}") String username,
                                                          @Value("${wms.nexus.password}") String password) {
        return new BasicAuthRequestInterceptor(username, password);
    }
}
