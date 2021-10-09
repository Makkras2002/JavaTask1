package com.makkras.parser.impl;

import com.makkras.entity.impl.SomeArray;
import com.makkras.exception.FileInteractionException;
import com.makkras.fileops.DataReaderFromFile;
import com.makkras.fileops.impl.CustomDataReaderFromFile;
import com.makkras.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CustomDataParserTest {
    private DataReaderFromFile fileReader;
    private static Logger logger = LogManager.getLogger();
    private DataParser parser;
    private SomeArray array;
    @BeforeMethod
    public void setUp() {
        fileReader = new CustomDataReaderFromFile();
        parser = new CustomDataParser();
        array = new SomeArray();
    }
    @Test
    public void testDataParser(){
        try {
            array = parser.extractToArray(fileReader.readDataFromFileIntoStringList("filesfoulder/testSource.txt"));
            assertEquals(array.getLength(),7);

        } catch (FileInteractionException e) {
            logger.error(e.getMessage());
        }
    }
}