package org.taba.msaapp.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.taba.msaapp.models.enums.MobileOperators;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequestDto {
    // TODO: 7/24/2023 pedram: mahyar : mobile number is not editable ??
//    private String mobileNumber;
    private Short gender;
    private Date birthDate;
    private String province;
    private String city;
    private String address;
    private String postalCode;
    private String phone;
    private String email;
    private MobileOperators mobileOperator;
    // TODO: 7/25/23
    private String nationalCode;
}
