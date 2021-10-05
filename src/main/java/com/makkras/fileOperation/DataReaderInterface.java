package com.makkras.fileOperation;

import com.makkras.exception.FileInteractionException;

import java.util.List;

public interface DataReaderInterface {
    public List<String> readDataFromFileIntoStringList(String filepath) throws FileInteractionException;
}
