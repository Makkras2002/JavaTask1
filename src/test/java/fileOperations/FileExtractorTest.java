package fileOperations;

import entities.SomeArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileExtractorTest {
    SomeArray array;
    FileExtractor extractor;
    @BeforeMethod
    public void setUp() {
        array = new SomeArray();
        extractor = new FileExtractor();
    }

    @Test(timeOut = 400)
    public void testExtractFromFileToArrayTime() {
        for(int i  =0 ; i<50; i++){
            array = extractor.extractFromFileToArray("testSource.txt");
        }
    }
    @Test
    public void testExtractFromFileToArrayCorrectness() {
        array = extractor.extractFromFileToArray("testSource.txt");
        assertEquals(array.getLength(),7);
    }
}