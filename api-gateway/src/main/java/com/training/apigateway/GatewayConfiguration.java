package com.training.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouting(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/unit-service/**")
						.uri("lb://unit-service"))
				.route(p->p.path("/conversion-service/**")
						.uri("lb://conversion-service"))
				.route(p->p.path("/conversion-service-dummy/**")
						.filters(f->f.rewritePath("/conversion-service-dummy/(?<segment>.*)"
						, "/conversion-service/${segment}"))
						.uri("lb://conversion-service"))
				.build();
	}

}
