package com.demir.FakeDataGeneratorWeb.web.components;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

@Validated
public class PasswordLengthDataModel {
    @Min(0)
    @Max(20)
    private static int passwordLength;

    public static int getPasswordLength() {
        return passwordLength;
    }

    public static void setPasswordLength(int passwordLength) {
        PasswordLengthDataModel.passwordLength = passwordLength;
    }
}
