package com.epam.infohangling.core;

import com.epam.infohangling.ChainBuilder;
import com.epam.infohangling.Component;
import com.epam.infohangling.parsers.Parser;
import com.epam.infohangling.parsers.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static java.util.Objects.nonNull;

public class TextManipulator {

    private final Logger LOGGER = LogManager.getLogger(TextManipulator.class);

    public String readFile(String path) throws IOException {

        BufferedReader bufferedReader = null;
        String content = "";

        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!(content=="")) {
                    content = content + "\n";
                }
                content = content + line;
            }
        }catch (IOException e) {
            LOGGER.error(e);
            throw e;
        } finally {
            if (nonNull(bufferedReader)) {
                bufferedReader.close();
            }
        }
        //System.out.print(content);
        //writeFile(content,"src/test/resources/out.txt");
        parseText(content);
        return content;
    }

    public void writeFile(String content, String path) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
        }catch (IOException e) {
            LOGGER.error(e);
            throw e;
        } finally {
            if (nonNull(bufferedWriter)) {
                bufferedWriter.close();
            }
        }
    }

    public Component parseText(String text) {
        ChainBuilder chainBuilder = new ChainBuilder();
        TextParser textParser = chainBuilder.build();
        Component component = textParser.parser(text);
        System.out.print(component);
        return component;
    }
}
