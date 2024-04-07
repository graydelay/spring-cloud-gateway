package com.example.springcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 클래스 설명 or 서비스 설명
 *
 * <br><br>$com.example.springcloudgateway.config.FilterConfig.java
 *
 * @version 1.0.0
 * @author 이지연    jylee@datasolution.kr
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일		수정자     수정내용
 * ------------------------------------------------------------------------------------
 * 2024.04.07      이지연     최초작성
 *
 * </pre>
 * @since 2024.04.07 오후 14:46:53
 */
//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-response", "first-response-header"))
                        .uri("http://localhost:8081/"))
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082/"))
                .build();
    }
}
