package com.makkras.fileOperations;

import com.makkras.entities.SomeArray;
import com.makkras.exeptions.FileInteractionException;

public interface FileExtractorInterface {
    SomeArray extractFromFileToArray(String filepath) throws FileInteractionException;
}
