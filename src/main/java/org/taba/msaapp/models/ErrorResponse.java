package org.taba.msaapp.models;

import lombok.Data;

@Data
public class ErrorResponse {
    String statusCode;
    Boolean isError;
    ResponseExp responseExp;
    String type;
    String title;
    int status;
    String traceId;
//    HttpStatus httpStatus;

}
