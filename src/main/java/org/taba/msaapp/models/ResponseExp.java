package org.taba.msaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseExp implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    public ExceptionMessage exceptionMessage;

}
