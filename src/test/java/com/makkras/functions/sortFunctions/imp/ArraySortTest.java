package com.makkras.functions.sortFunctions.imp;

import com.makkras.entities.SomeArray;
import com.makkras.fileOperations.imp.FileExtractor;
import com.makkras.functions.sortFunctions.imp.ArraySort;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ArraySortTest {
    ArraySort arraySort;
    FileExtractor extractor;
    @BeforeMethod
    public void setUp() {
        arraySort = new ArraySort();
        extractor = new FileExtractor();
    }
    @Test(timeOut = 100)
    public void TestBubbleSortTime(){
        SomeArray array = extractor.extractFromFileToArray("testSource.txt");
        SomeArray arrayPreSort = array;
        for(int i = 0;i<1000;i++){
            arraySort.bubbleSort(array);
            array = arrayPreSort;
        }
    }
}