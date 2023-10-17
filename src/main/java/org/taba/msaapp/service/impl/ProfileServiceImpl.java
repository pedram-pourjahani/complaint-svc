package org.taba.msaapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taba.msaapp.models.dto.RestResponseDto;
import org.taba.msaapp.models.dto.request.ProfileRequestDto;
import org.taba.msaapp.models.dto.response.ProfileResponseDto;
import org.taba.msaapp.models.entity.ProfileEntity;
import org.taba.msaapp.repository.ProfileRepository;
import org.taba.msaapp.service.api.ProfileService;
import org.taba.msaapp.utils.mapper.ProfileMapper;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    public Mono<ProfileResponseDto> findByNationalCode(String nationalCode) {
        Mono<ProfileEntity> userProfile = profileRepository.findByNationalcode(nationalCode);
        return userProfile.map(ProfileMapper::mapEntityToDto);
    }

    @Override
    public Mono<RestResponseDto<Boolean>> updateProfile(ProfileRequestDto profileRequestDto) {
        Mono<ProfileEntity> monoByNationalCode = profileRepository.findByNationalcode(profileRequestDto.getNationalCode());
        return monoByNationalCode.map(foundProfileEntity -> doUpdate(foundProfileEntity, profileRequestDto))
                .switchIfEmpty(Mono.error(() -> new RuntimeException("error")));
    }

    private RestResponseDto<Boolean> doUpdate(ProfileEntity foundProfileEntity, ProfileRequestDto profileRequestDto) {
//      TODO: 7/26/23 pedram set dto values in entity
        profileRepository.save(foundProfileEntity);
        return new RestResponseDto<>();
    }
}
