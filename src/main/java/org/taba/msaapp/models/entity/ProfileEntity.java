package org.taba.msaapp.models.entity;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(value = "PROFILE")
public class ProfileEntity extends BaseEntity {
    @Id
    @Column(value = "ID")
    private Long id;

    @Column(value = "PERSON")
    private Long person;

    @Column(value = "APPLICATIONID")
    private String applicationid;

    @Column(value = "MOBILENUMBER")
    private String mobilenumber;

    @Column(value = "FIRSTNAME")
    private String firstname;

    @Column(value = "LASTNAME")
    private String lastname;

    @Column(value = "NATIONALCODE")
    private String nationalcode;

    @Column(value = "BIRTHDATE")
    private Date birthdate;

    @Column(value = "LOCATION")
    private Long location;

    @Column(value = "ADDRESS")
    private String address;

    @Column(value = "PHONENUMBER")
    private String phonenumber;

    @Column(value = "POSTALCODE")
    private String postalcode;

    @Column(value = "EMAIL")
    private String email;

    @Column(value = "GENDER")
    private String gender;

    @Column(value = "MOBILEOPERATOR")
    private String mobileoperator;

    @Column(value = "AVATARPATH")
    private String avatarpath;


}
