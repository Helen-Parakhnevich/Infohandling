package com.epam.infohangling.service;

import com.epam.infohangling.core.TextManipulator;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final static TextManipulator textManipulator = new TextManipulator();

    @Test
    public void testReadFileWhenFileExists() throws IOException {
        //given
        String path = "src/test/resources/text.txt";
        String expectedContent = "";

        //when
       String result = textManipulator.readFile(path);

        //then
        Assert.assertEquals(expectedContent, result);
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadFileWhenFileNotExists() throws IOException {
        //given
        String path = "src/test/resources/coord.txt";
        List<String> dataList = Arrays.asList();

        //when
       // List<String> result = dataReader.readFile(path);

        //then
        //Assert.assertEquals(dataList, result);
    }


}
