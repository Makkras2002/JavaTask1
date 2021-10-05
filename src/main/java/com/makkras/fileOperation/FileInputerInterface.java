package com.makkras.fileOperation;

import com.makkras.exception.FileInteractionException;


public interface FileInputerInterface {
    void putNumberIntoFile(String number,String filepath)throws FileInteractionException;
}
