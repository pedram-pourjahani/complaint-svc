package org.taba.msaapp.models.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponseDto {

    private String nationalCode;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private Short gender;
    private Date birthDate;
    private String province;
    private String city;
    private String address;
    private String postalCode;
    private String phone;
    private String email;
    private String mobileOperator;

}
