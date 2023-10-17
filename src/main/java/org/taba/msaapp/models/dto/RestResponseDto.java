package org.taba.msaapp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponseDto<T> {

    private String message;
    private boolean isError;
    private String responseCode;
    private T data;

    public RestResponseDto(boolean isError, T data) {
        this.isError = isError;
        this.message = isError ? "error" : "success";
        this.responseCode = isError ? "500" : "0";
        this.data = data;
    }

    public RestResponseDto(boolean isError, String message) {
        this.isError = isError;
        this.message = message;
        this.responseCode = isError ? "500" : "0";
        this.data = null;
    }

    public static  <T> RestResponseDto<T> success(T data){
        return new RestResponseDto(false, data);
    }

    public static  <T> RestResponseDto<T> failure(){
        return new RestResponseDto(true, null);
    }
    public static  <T> RestResponseDto<T> failure(String message){
        return new RestResponseDto(true, message);
    }
}
