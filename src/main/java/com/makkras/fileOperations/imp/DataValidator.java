package com.makkras.fileOperations.imp;

import com.makkras.fileOperations.DataValidatorInterface;

public class DataValidator implements DataValidatorInterface {
private final static String pattern = "-?\\d+(\\.\\d+)?";
public boolean checkIfNumber(String string){
    if(string.matches(pattern)){
        return true;
    }
    else {
        return false;
    }
}
}
