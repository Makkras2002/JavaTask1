package functions.sortFunctions;

import entities.SomeArray;
import fileOperations.FileExtractor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

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