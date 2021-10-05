package com.makkras.fileops;

import com.makkras.exception.FileInteractionException;


public interface FileOutputer {
    void putNumberIntoFile(String number,String filepath)throws FileInteractionException;
}
