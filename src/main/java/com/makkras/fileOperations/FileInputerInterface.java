package com.makkras.fileOperations;

import com.makkras.exeptions.FileInteractionException;


public interface FileInputerInterface {
    void putNumberIntoFile(String number,String filepath)throws FileInteractionException;
}
