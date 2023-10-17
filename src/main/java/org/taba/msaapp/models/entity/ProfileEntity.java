package org.taba.msaapp.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PROFILE")
public class ProfileEntity extends BaseEntity {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERSON")
    private Long person;

    @Column(name = "APPLICATIONID")
    private String applicationid;

    @Column(name = "MOBILENUMBER")
    private String mobilenumber;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "NATIONALCODE")
    private String nationalcode;

    @Column(name = "BIRTHDATE")
    private Date birthdate;

    @Column(name = "LOCATION")
    private Long location;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONENUMBER")
    private String phonenumber;

    @Column(name = "POSTALCODE")
    private String postalcode;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "MOBILEOPERATOR")
    private String mobileoperator;

    @Column(name = "AVATARPATH")
    private String avatarpath;


}
