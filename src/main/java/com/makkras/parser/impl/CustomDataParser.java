package com.makkras.parser.impl;

import com.makkras.entity.impl.SomeArray;
import com.makkras.validator.DataValidator;
import com.makkras.validator.impl.CustomValidator;
import com.makkras.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomDataParser implements DataParser {
    private static Logger logger = LogManager.getLogger();
    public SomeArray extractToArray(List<String> list){
        DataValidator dataValidator= new CustomValidator();
        int arraySize =0;
        SomeArray array;
        List<Integer> goodLinesList = new ArrayList<>();
        String[] rawDataArray;
        String line;
        boolean isGoodLine = true;
        int lineCounter =0;
        int tempArraySizeIncrease =0;
        int tempCounter1 =0;
        while (tempCounter1<list.size()){
            line = list.get(tempCounter1);
            rawDataArray = line.split(";");
            int rawC =0;
            while (rawC < rawDataArray.length){
                if(dataValidator.checkIfNumber(rawDataArray[rawC])){
                    arraySize++;
                    tempArraySizeIncrease++;
                }else {
                    logger.error("Invalid data found in file.");
                    arraySize =arraySize-tempArraySizeIncrease;
                    isGoodLine = false;
                    break;
                }
                rawC++;
            }
            if(isGoodLine){
                goodLinesList.add(lineCounter);
            }
            lineCounter++;
            isGoodLine = true;
            tempArraySizeIncrease = 0;
            tempCounter1++;
        }
        array = new SomeArray(arraySize);
        int tempCounter = 0;
        tempCounter1 =0;
        int extractorLineCounter = 0;
        while (tempCounter1<list.size()){
            line = list.get(tempCounter1);
            int rawC =0;
            while (rawC < goodLinesList.size()){
                if(extractorLineCounter == goodLinesList.get(rawC)){
                    rawDataArray = line.split(";");
                    for (String a : rawDataArray){
                        array.setNumber(tempCounter,Float.parseFloat(a));
                        tempCounter++;
                    }
                    break;
                }
                rawC++;
            }
            tempCounter1++;
            extractorLineCounter++;
        }
        return array;
    }
}