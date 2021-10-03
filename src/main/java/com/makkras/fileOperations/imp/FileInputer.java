package com.makkras.fileOperations.imp;

import com.makkras.exceptions.FileInteractionException;
import com.makkras.fileOperations.FileInputerInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputer implements FileInputerInterface {
    private static Logger logger = LogManager.getLogger();
    public void putNumberIntoFile(String number,String filepath) throws FileInteractionException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(filepath,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(number + "\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error.",e.getCause());
        }
    }
}
