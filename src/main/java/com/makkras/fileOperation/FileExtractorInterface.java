package com.makkras.fileOperation;

import com.makkras.entity.SomeArray;
import com.makkras.exception.FileInteractionException;

public interface FileExtractorInterface {
    SomeArray extractFromFileToArray(String filepath) throws FileInteractionException;
}
