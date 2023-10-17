package org.taba.msaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class MResponse implements Serializable {
    String message = "POST request successful.";
    Boolean isError = false;
    Integer responseCode = 0;
    Object data;
}
