package com.makkras.fileOperation.imp;

import com.makkras.entity.SomeArray;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileOperation.DataValidatorInterface;
import com.makkras.fileOperation.FileExtractorInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileExtractor implements FileExtractorInterface{
    private static Logger logger = LogManager.getLogger();
    DataValidatorInterface dataValidator= new DataValidator();
    public SomeArray extractFromFileToArray(String filepath) throws FileInteractionException{
        BufferedReader bufferedReader = null;
        int arraySize =0;
        SomeArray array;
        FileReader fileReader = null;
        List<Integer> goodLinesList = new ArrayList<>();
        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);
            String[] rawDataArray;
            String line = bufferedReader.readLine();
            boolean isGoodLine = true;
            int lineCounter =0;
            int tempArraySizeIncrease =0;
            while (line != null){
                rawDataArray = line.split(";");
                for (String o : rawDataArray){
                    if(dataValidator.checkIfNumber(o)){
                        arraySize++;
                        tempArraySizeIncrease++;
                    }else {
                        logger.error("Invalid data found in file.");
                        arraySize =arraySize-tempArraySizeIncrease;
                        isGoodLine = false;
                        break;
                    }
                }
                if(isGoodLine){
                    goodLinesList.add(lineCounter);
                }
                lineCounter++;
                isGoodLine = true;
                tempArraySizeIncrease = 0;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            array = new SomeArray(arraySize);
            int tempCounter = 0;
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            int extractorLineCounter = 0;
            while (line != null){
                for(int o : goodLinesList){
                    if(extractorLineCounter == o){
                        rawDataArray = line.split(";");
                        for (String a : rawDataArray){
                            array.setNumber(tempCounter,Float.parseFloat(a));
                            tempCounter++;
                        }
                        break;
                    }
                }
                line = bufferedReader.readLine();
                extractorLineCounter++;
            }
            fileReader.close();
            bufferedReader.close();
            return array;
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error.",e.getCause());
        }
    }
}