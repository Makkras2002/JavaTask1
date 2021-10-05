package com.makkras.fileOperation.imp;

import com.makkras.entity.SomeArray;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileOperation.DataReaderInterface;
import com.makkras.fileOperation.DataValidatorInterface;
import com.makkras.fileOperation.imp.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderFromFile implements DataReaderInterface {
    private static Logger logger = LogManager.getLogger();
    DataValidatorInterface dataValidator= new DataValidator();
    public List<String> readDataFromFileIntoStringList(String filepath) throws FileInteractionException {
        BufferedReader bufferedReader = null;
        int arraySize =0;
        SomeArray array;
        FileReader fileReader = null;
        List<String> list =new ArrayList<>();
        try {
            fileReader = new FileReader(filepath);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                list.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
            fileReader.close();
            bufferedReader.close();
            return list;
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error.",e.getCause());
        }
    }
}
