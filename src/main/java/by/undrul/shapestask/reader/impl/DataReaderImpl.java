package by.undrul.shapestask.reader.impl;


import by.undrul.shapestask.exception.ShapeException;
import by.undrul.shapestask.reader.DataReader;
import by.undrul.shapestask.validator.FileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {

    private static Logger logger = LogManager.getLogger();

    @Override
    public ArrayList<String> readDataFromFile(String path) throws ShapeException {
        logger.info("Method to read data from file started");

        if (!FileValidator.isFileValid(path)) {
            throw new ShapeException("File " + path + " is empty or don't exist or has incorrect filepath");
        }

        ArrayList<String> dataFromFile = new ArrayList<>();
        File file = new File(path);

        try (Stream<String> linesStream = Files.lines(file.toPath())) {
            linesStream.forEach(dataFromFile::add);

        } catch (Exception e) {
            throw new ShapeException("File is not found", e);
        }

        logger.info("Data from file read");
        return dataFromFile;

    }
}
