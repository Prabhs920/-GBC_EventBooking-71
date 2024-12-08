package ca.gbc.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("booking-service", r -> r.path("/booking-service/**")
                        .filters(f -> f.rewritePath("/booking-service/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8087"))
                .route("room-service", r -> r.path("/room-service/**")
                        .filters(f -> f.rewritePath("/room-service/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8088"))
                .route("event-service", r -> r.path("/event-service/**")
                        .filters(f -> f.rewritePath("/event-service/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8086"))
                .route("approval-service", r -> r.path("/approval-service/**")
                        .filters(f -> f.rewritePath("/approval-service/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8090"))
                .route("user-service", r -> r.path("/user-service/**")
                        .filters(f -> f.rewritePath("/user-service/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8091"))
                .build();
    }
}
