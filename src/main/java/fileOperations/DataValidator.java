package fileOperations;

public class DataValidator {
private final static String pattern = "-?\\d+(\\.\\d+)?";
public static boolean checkIfNumber(String string){
    if(string.matches(pattern)){
        return true;
    }
    else {
        return false;
    }
}
}
