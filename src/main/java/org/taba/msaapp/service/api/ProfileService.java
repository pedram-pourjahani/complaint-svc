package org.taba.msaapp.service.api;


import org.taba.msaapp.models.dto.RestResponseDto;
import org.taba.msaapp.models.dto.request.ProfileRequestDto;
import org.taba.msaapp.models.dto.response.ProfileResponseDto;
import reactor.core.publisher.Mono;

public interface ProfileService {

    Mono<ProfileResponseDto> findByNationalCode(String nationalCode);
    Mono<RestResponseDto<Boolean>> updateProfile(ProfileRequestDto profileRequestDto);
}
