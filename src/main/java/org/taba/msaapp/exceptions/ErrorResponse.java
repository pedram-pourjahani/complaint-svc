package org.taba.msaapp.exceptions;

import lombok.Data;
import org.taba.msaapp.models.ResponseExp;

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
