package com.energy.gateway;

import com.energy.gateway.config.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/auth/**")
                .filters(f -> f.filter(filter))
                .uri("lb://AUTHENTICATIONAPI"))
            .route(r -> r.path("/api/v2/**")
               .filters(f -> f.filter(filter))
                .uri("lb://TWEETAPI"))
            .build();
        //test later
    }
}
