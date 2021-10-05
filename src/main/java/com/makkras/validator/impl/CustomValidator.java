package com.makkras.validator.impl;

import com.makkras.validator.DataValidator;

public class CustomValidator implements DataValidator {
private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";
public boolean checkIfNumber(String string){
    return string.matches(NUMBER_PATTERN);
}
}
