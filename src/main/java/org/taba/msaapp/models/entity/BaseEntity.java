package org.taba.msaapp.models.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {

    @Column(value = "CREATEAT")
    private Date createat;

    @Column(value = "CREATEBY")
    private Long createby;

    @Column(value = "MODIFIEDAT")
    private Date modifiedat;

    @Column(value = "MODIFIEDBY")
    private Long modifiedby;
}
