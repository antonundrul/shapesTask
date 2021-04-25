package by.undrul.shapestask.reader;

import by.undrul.shapestask.exception.ShapeException;

import java.util.ArrayList;

public interface DataReader {
    ArrayList<String> readDataFromFile(String path) throws ShapeException;
}
