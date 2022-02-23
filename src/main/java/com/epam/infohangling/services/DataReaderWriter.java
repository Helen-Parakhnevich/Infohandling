package com.epam.infohangling.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Objects.nonNull;

public class DataReaderWriter {

    private final Logger LOGGER = LogManager.getLogger(TextManipulator.class);

    public String readFile(String path) throws IOException {

        BufferedReader bufferedReader = null;
        String content = new String(Files.readAllBytes(Paths.get(path)));

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

}
