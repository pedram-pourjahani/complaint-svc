package org.taba.msaapp.models;

import lombok.Data;

@Data
public class CaptchaResponseData {
    Integer captchaKey;
    String captchaImage;
}
