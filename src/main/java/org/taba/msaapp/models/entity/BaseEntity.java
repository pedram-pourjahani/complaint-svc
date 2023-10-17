package org.taba.msaapp.models.entity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseEntity {

    @Column(name = "CREATEAT")
    private Date createat;

    @Column(name = "CREATEBY")
    private Long createby;

    @Column(name = "MODIFIEDAT")
    private Date modifiedat;

    @Column(name = "MODIFIEDBY")
    private Long modifiedby;
}
