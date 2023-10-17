package org.taba.msaapp.utils;

import org.taba.msaapp.models.dto.RestResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class RestUtil {

    public static <T> Mono<RestResponseDto<T>> completeRestResponseChain(Mono<T> mono) {
        return mono.map(RestResponseDto::success)
                .onErrorResume(throwable -> Mono.just(RestResponseDto.failure(throwable.getMessage())) );
    }

    public static <T> Mono<RestResponseDto<List<T>>> completeRestResponseChain(Flux<T> flux) {
        return completeRestResponseChain(flux.collectList());
    }
}
