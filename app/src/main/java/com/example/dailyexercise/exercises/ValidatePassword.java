package com.example.dailyexercise.exercises;

import java.util.HashMap;
import java.util.Map;

public class ValidatePassword {

    public static final String LOWER = "lower";
    public static final String UPPER = "upper";
    public static final String DIGIT = "digit";

    public static Map<String, Boolean> CheckValidate(String password) {



        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        Map<String, Boolean> validate = new HashMap<>();

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUppercase = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowercase = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
            }
        }
        validate.put(UPPER, hasUppercase);
        validate.put(LOWER, hasLowercase);
        validate.put(DIGIT, hasDigit);

        return validate;
    }

}
