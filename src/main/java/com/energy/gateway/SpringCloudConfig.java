package com.energy.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/consumption/**")
                        .filters(f -> f.addRequestHeader("something", "something"))
                        .uri("lb://TEST-SERVICE"))
                .build();
    }
    //TODO thinking about possible circuitBreaker implementation against poorly behaving services: resilience4j dependency

}
