package main;

import entities.SomeArray;
import fileOperations.FileExtractor;
import fileOperations.FileInputer;
import functions.ArrayFunctions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        boolean signal = true;
        Scanner scanner = new Scanner(System.in);
        SomeArray array =new SomeArray();
        FileExtractor fileExtractor = new FileExtractor();
        ArrayFunctions arrayFunctions = new ArrayFunctions();
        FileInputer fileInputer = new FileInputer();
        boolean isRead = false;
        while (signal){
            logger.info("1. Read numbers from file.");
            logger.info("2. Find max/main elements in the array.");
            logger.info("3. Divide all negative elements in the array on 2.");
            logger.info("4. Count average in the array.");
            logger.info("5. Count elemSum in the array.");
            logger.info("6. Count amount of positive/negative elements in the array.");
            logger.info("7. Add number to the source file.");
            logger.info("8. Show array.");
            logger.info("9. Exit.");
            switch (scanner.nextLine()){
                case "1":{
//                    try {
//                        array = fileExtractor.extractNumbersFromFileToArray();
//                        isRead = true;
//                    } catch (IOException e) {
//                        logger.error(e.getMessage());
//                    }
                    array = fileExtractor.extractFromFileToArray();
                    isRead = true;
                    break;
                }
                case "2":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info(arrayFunctions.findMaxMinElements(array));
                    }
                    break;
                }
                case "3":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        arrayFunctions.changeElementsByTask(array);
                    }
                    break;
                }
                case "4":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("AVERAGE: "+ arrayFunctions.countAverage(array));
                    }
                    break;
                }
                case "5":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("SUM: "+ arrayFunctions.countElemSum(array));
                    }
                    break;
                }
                case "6":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info(arrayFunctions.countPositiveNegativeAmount(array));
                    }
                    break;
                }
                case "7":{
                    String newFileData = scanner.nextLine();
                    try {
                        fileInputer.putNumberIntoFile(newFileData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "8":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        array.showArray();
                    }
                    break;
                }
                case "9":{
                    return;
                }
            }
        }
    }
}
