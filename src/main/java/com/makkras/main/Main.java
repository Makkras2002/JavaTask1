package com.makkras.main;

import com.makkras.entity.impl.SomeArray;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileops.impl.CustomDataReaderFromFile;
import com.makkras.validator.DataValidator;
import com.makkras.validator.impl.CustomValidator;
import com.makkras.parser.impl.CustomDataParser;
import com.makkras.fileops.impl.FileDataOutputer;
import com.makkras.survice.impl.ArrayMathFunc;
import com.makkras.survice.sort.impl.ArraySort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        boolean signal = true;
        Scanner scanner = new Scanner(System.in);
        SomeArray array =new SomeArray();
        CustomDataParser parser = new CustomDataParser();
        ArrayMathFunc arrayFunctions = new ArrayMathFunc();
        FileDataOutputer fileOutputer = new FileDataOutputer();
        DataValidator dataValidator = new CustomValidator();
        ArraySort arraySort = new ArraySort();
        CustomDataReaderFromFile dataReaderFromFile = new CustomDataReaderFromFile();
        boolean isRead = false;
        while (signal){
            logger.info("1. Read numbers from file.");
            logger.info("2. Find max/min elements in the array.");
            logger.info("3. Divide all negative elements in the array on number.");
            logger.info("4. Count average in the array.");
            logger.info("5. Count elemSum in the array.");
            logger.info("6. Count amount of positive/negative elements in the array.");
            logger.info("7. Add number to the source file.");
            logger.info("8. Show array.");
            logger.info("9. Exit.");
            logger.info("10. Array BubbleSort.");
            logger.info("11. Array SelectionSort.");
            logger.info("12. Array InsertionSort.");
            logger.info("13. Find max/min elements in the array WITH STREAM.");
            logger.info("14. Count average in the array WITH STREAM.");
            logger.info("15. Count elemSum in the array WITH STREAM.");
            logger.info("16. Count amount of positive/negative elements in the array WITH STREAM.");
            logger.info("17. Array CustomSort WITH STREAM.");
            switch (scanner.nextLine()){
                case "1":{
                    try {
                        array = parser.extractToArray(dataReaderFromFile.readDataFromFileIntoStringList("filesfoulder/source.txt"));
                    } catch (FileInteractionException e) {
                        logger.error(e.getMessage());
                    }
                    isRead = true;
                    break;
                }
                case "2":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("MAX : " +arrayFunctions.findMaxElement(array) + "; MIN : "+arrayFunctions.findMinElement(array));
                    }
                    break;
                }
                case "3":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("Enter number to divide negative elements on.");
                        String number = scanner.nextLine();
                        if(dataValidator.checkIfNumber(number)){
                            if(Double.parseDouble(number) == 0){
                                logger.error("Invalid data was entered.");
                            }else {
                                arrayFunctions.changeElementsByTask(array,Double.parseDouble(number));
                            }
                        }else {
                            logger.error("Invalid data was entered.");
                            break;
                        }
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
                        logger.info("POSITIVE : " +arrayFunctions.countPositiveAmount(array) + "; NEGATIVE : "+arrayFunctions.countNegativeAmount(array));
                    }
                    break;
                }
                case "7":{
                    String newFileData = scanner.nextLine();
                    try {
                        fileOutputer.putNumberIntoFile(newFileData, "filesfoulder/source.txt");
                    } catch (FileInteractionException e) {
                        logger.error(e.getMessage());
                    }
                    break;
                }
                case "8":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info(array.toString());
                    }
                    break;
                }
                case "9":{
                    return;
                }
                case "10":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        arraySort.bubbleSort(array);
                    }
                    break;
                }
                case "11":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        arraySort.selectionSort(array);
                    }
                    break;
                }
                case "12":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        arraySort.insertionSort(array);
                    }
                    break;
                }
                case "13":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("MAX : " +arrayFunctions.findMaxElementWithStream(array) + "; MIN : "+arrayFunctions.findMinElementWithStream(array));
                    }
                    break;
                }
                case "14":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("AVERAGE: "+ arrayFunctions.countAverageWithStream(array));
                    }
                    break;
                }
                case "15":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("SUM: "+ arrayFunctions.countElemSumWithStream(array));
                    }
                    break;
                }
                case "16":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        logger.info("POSITIVE - " +arrayFunctions.countPositiveAmountWithStream(array) + "; NEGATIVE - "+arrayFunctions.countNegativeAmountWithStream(array));
                    }
                    break;
                }
                case "17":{
                    if(!isRead){
                        logger.error("Data wasn't read from file.");
                        break;
                    }else {
                        arraySort.arraySortWithStream(array);
                    }
                    break;
                }
            }
        }
    }
}
