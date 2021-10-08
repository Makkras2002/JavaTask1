package com.makkras.fileops.impl;

import com.makkras.exception.FileInteractionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileDataOutputer implements com.makkras.fileops.FileOutputer {
    public void putNumberIntoFile(String number,String filepath) throws FileInteractionException {
        try (FileWriter fileWriter = new FileWriter(filepath,true);BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write(number + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error."+ e.getMessage(),e.getCause());
        }
    }
}
