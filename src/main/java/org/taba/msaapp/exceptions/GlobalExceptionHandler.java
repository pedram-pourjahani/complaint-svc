package org.taba.msaapp.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.taba.msaapp.models.ExceptionMessage;
import org.taba.msaapp.models.ResponseExp;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse handleException(Exception ex) {
        log.error("internal server error : {}", ex);
        ErrorResponse errorResponse = buildErrResponse(HttpStatus.UNAUTHORIZED, Arrays.asList(ex.getMessage()), "Auth", "invalid authorization");
        return errorResponse;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse handleException(RuntimeException ex) {
        log.error("internal server error : {}", ex);
        ErrorResponse errorResponse = buildErrResponse(HttpStatus.UNAUTHORIZED, Arrays.asList(ex.getMessage()), "Auth", "invalid authorization");
        return errorResponse;
    }

    private ErrorResponse buildErrResponse(HttpStatus status, List<String> messages, String type, String title) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setIsError(true);
        errorResponse.setStatusCode(String.valueOf(status.value()));
        ResponseExp responseExp = new ResponseExp();
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        for (String msg : messages) {
            exceptionMessage.getErrors().add(msg);
        }
        responseExp.setExceptionMessage(exceptionMessage);
        errorResponse.setResponseExp(responseExp);
        errorResponse.setType(type);
        errorResponse.setTitle(title);
        errorResponse.setStatus(status.value());
        errorResponse.setTraceId(String.valueOf(UUID.randomUUID()));
        return errorResponse;
    }


}
