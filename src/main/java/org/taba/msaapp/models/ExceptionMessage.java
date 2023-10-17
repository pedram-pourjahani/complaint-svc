package org.taba.msaapp.models;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ExceptionMessage implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    public List<String> errors = new ArrayList<>();
}
