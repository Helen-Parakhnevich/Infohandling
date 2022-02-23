package com.epam.infohangling.exeptions;

import com.epam.infohangling.services.TextManipulator;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReaderTest {

    private final static TextManipulator textManipulator = new TextManipulator();

    @Test
    public void testReadFileWhenFileExists() throws IOException {
//        //given
//        String path = "src/test/resources/text.txt";
//        String expectedContent = "";
//
//        //when
//       String result = textManipulator.readFile(path);
//
//        //then
    }

    @Test
    public void testSplit() {
        String s = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +] essentially [15  3 /] unchanged.";
        String regex = "(\\[.*?\\])";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        List<String> opz = new ArrayList<>();
        while (m.find()) {
            opz.add(m.group());
        }

        List<String> splitText = Arrays.asList(s.split(regex));

        int maxIterations = splitText.size() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxIterations; i++) {
            result.append(splitText.get(i));
            result.append(opz.get(i));
        }
        result.append(splitText.get(splitText.size() - 1));

        Assert.assertEquals(s, result.toString());
    }


}
