//package org.taba.msaapp.config.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.taba.msaapp.config.properties.IgnoredPaths;
//import org.taba.msaapp.filter.CustomAuthenticationFilter;
//import org.taba.msaapp.utils.JwtUtils;
//
//@Configuration
//@EnableWebFluxSecurity
//public class CustomSecurityConfig {
//    @Autowired
//    private JwtUtils jwtUtils;
//    @Autowired
//    private IgnoredPaths ignoredPaths;
//    @Autowired
//    private WebClient webClient;
//
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(
//            ServerHttpSecurity http) {
//        return http.cors().disable()
//                .csrf().disable()
//                .httpBasic().disable()
//                .formLogin().disable()
//                .anonymous().disable()
//                .authorizeExchange().pathMatchers(ignoredPaths.getPath().toArray(new String[]{})).permitAll().and()
//                .authorizeExchange().anyExchange().authenticated()
//                .and().addFilterAfter(new CustomAuthenticationFilter(jwtUtils, ignoredPaths.getPath().toArray(new String[]{}), webClient), SecurityWebFiltersOrder.REACTOR_CONTEXT).build();
//    }
//}
