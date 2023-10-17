package org.taba.msaapp.utils.mapper;

import org.taba.msaapp.models.dto.response.ProfileResponseDto;
import org.taba.msaapp.models.entity.ProfileEntity;

public class ProfileMapper {

    public static ProfileResponseDto mapEntityToDto(ProfileEntity profileEntity) {
        return new ProfileResponseDto();
//        return ProfileResponseDto.builder()
//                .id(profileEntity.getId())
//                .title(profileEntity.getTitle())
//                .code(profileEntity.getCode())
//                // TODO: 7/25/2023 pedram : mahyar : check property type
//                .parentCode("")
//                .parentTitle("")
//                .build();
    }
}
