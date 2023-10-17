//package org.taba.msaapp.filter;
//
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.ReactiveSecurityContextHolder;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextImpl;
//import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
//import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import org.taba.msaapp.exceptions.BussineseException;
//import org.taba.msaapp.utils.JwtUtils;
//import reactor.core.publisher.Mono;
//
//import java.util.Arrays;
//
//public class CustomAuthenticationFilter implements WebFilter {
//    private final JwtUtils jwtUtils;
//    private final String[] ignoredPath;
//    private final WebClient webClient;
//
//    public CustomAuthenticationFilter(JwtUtils jwtUtils, String[] ignoredPath, WebClient webClient) {
//        this.jwtUtils = jwtUtils;
//        this.ignoredPath = ignoredPath;
//        this.webClient = webClient;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        String authorizationHeader = exchange.getRequest().getHeaders().get("AUTHORIZATION").get(0);
//        String token = authorizationHeader.substring(7);
//
//        return WebClient.create().post()
//                .uri("http://localhost:8085/app/authenticate")
//                .header("AUTHORIZATION", token)
//                .exchange()
//                .flatMap(response -> {
//                    if (response.statusCode().is2xxSuccessful()) {
//                        String username = jwtUtils.getUsernameFromToken(token.substring(7));
//                        SecurityContext securityContext = new SecurityContextImpl();
//                        Authentication authentication = this.createAuthentication(username);
//                        securityContext.setAuthentication(authentication);
//                        return exchange.getSession().map(webSession -> {
//                            webSession.getAttributes().put("current_user", username);
//                            return webSession;
//                        }).then(
//                                chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(securityContext))).then(Mono.empty())
//                        );
//                    } else {
//                        throw new BussineseException("token is not valid");
//                    }
//                });
//
////        return Mono.just(exchange)
////                .filterWhen(this::shouldFilter)
////                .switchIfEmpty(chain.filter(exchange).then(Mono.empty())).flatMap(serverWebExchange -> {
////
////                    String username = jwtUtils.getUsernameFromToken(token);
////                    SecurityContext securityContext = new SecurityContextImpl();
////                    Authentication authentication = this.createAuthentication(username);
////                    securityContext.setAuthentication(authentication);
////                    return serverWebExchange.getSession().map(webSession -> {
////                        webSession.getAttributes().put("current_user", username);
////                        return webSession;
////                    }).then(
////                            chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(securityContext))).then(Mono.empty())
////                    );
////                });
//    }
//
//    private boolean someCondition(String res) {
//        return false;
//    }
//
//    protected Authentication createAuthentication(String username) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, Arrays.asList());
//        return usernamePasswordAuthenticationToken;
//    }
//
//
//    private Mono<Boolean> shouldFilter(ServerWebExchange exchange) {
//        return new NegatedServerWebExchangeMatcher(ServerWebExchangeMatchers.pathMatchers(ignoredPath))
//                .matches(exchange).map(matchResult -> matchResult.isMatch());
//
//    }
//
//}
