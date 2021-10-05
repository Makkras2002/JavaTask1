package com.makkras.functions.sortFunction.imp;

import com.makkras.entity.SomeArray;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileOperation.imp.FileExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ArraySortTest {
    public ArraySort arraySort;
    public FileExtractor extractor;
    private static Logger logger = LogManager.getLogger();
    @BeforeMethod
    public void setUp() {
        arraySort = new ArraySort();
        extractor = new FileExtractor();
    }
    @Test(timeOut = 100)
    public void TestBubbleSortTime(){
        SomeArray array = null;
        try {
            array = extractor.extractFromFileToArray("testSource.txt");
        } catch (FileInteractionException e) {
            logger.error(e.getMessage());
        }
        SomeArray arrayPreSort = array;
        for(int i = 0;i<1000;i++){
            arraySort.bubbleSort(array);
            array = arrayPreSort;
        }
    }
}