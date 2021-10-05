package com.makkras.fileOperation.imp;

import com.makkras.entity.SomeArray;
import com.makkras.exception.FileInteractionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileExtractorTest {
    public SomeArray array;
    public FileExtractor extractor;
    private static Logger logger = LogManager.getLogger();
    @BeforeMethod
    public void setUp() {
        array = new SomeArray();
        extractor = new FileExtractor();
    }

    @Test(timeOut = 400)
    public void testExtractFromFileToArrayTime() {
        for(int i  =0 ; i<50; i++){
            try {
                array = extractor.extractFromFileToArray("testSource.txt");
            } catch (FileInteractionException e) {
                logger.error(e.getMessage());
            }
        }
    }
    @Test
    public void testExtractFromFileToArrayCorrectness() {
        try {
            array = extractor.extractFromFileToArray("testSource.txt");
        } catch (FileInteractionException e) {
            logger.error(e.getMessage());
        }
        assertEquals(array.getLength(),7);
    }
}