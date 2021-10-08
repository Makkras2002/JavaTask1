package com.makkras.fileops.impl;

import com.makkras.exception.FileInteractionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomDataReaderFromFile implements com.makkras.fileops.DataReaderFromFile {
    public List<String> readDataFromFileIntoStringList(String filepath) throws FileInteractionException {
        List<String> list =new ArrayList<>();
        try (FileReader fileReader = new FileReader(filepath);BufferedReader bufferedReader =new BufferedReader(fileReader)){
            String line = bufferedReader.readLine();
            while (line != null){
                list.add(line);
                line = bufferedReader.readLine();
            }
            return list;
        } catch (IOException e) {
            throw new FileInteractionException("File interaction error: " + e.getMessage(),e.getCause());
        }
    }
}
