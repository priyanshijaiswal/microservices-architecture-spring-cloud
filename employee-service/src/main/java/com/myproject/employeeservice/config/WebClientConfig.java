package com.myproject.employeeservice.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

    @Configuration
    public class WebClientConfig {

        @Bean
        public WebClient webClient() {
            return WebClient.builder()
                    .filter(tokenRelayFilter())
                    .build();
        }

        private ExchangeFilterFunction tokenRelayFilter() {
            return (request, next) -> {
                HttpServletRequest servletRequest =
                        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                                .getRequest();

                String authHeader = servletRequest.getHeader("Authorization");

                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    ClientRequest newRequest = ClientRequest.from(request)
                            .header("Authorization", authHeader)
                            .build();
                    return next.exchange(newRequest);
                }

                return next.exchange(request);
            };
        }
    }

