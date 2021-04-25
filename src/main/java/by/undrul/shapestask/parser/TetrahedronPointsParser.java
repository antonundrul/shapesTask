package by.undrul.shapestask.parser;

import by.undrul.shapestask.entity.Point;

import java.util.ArrayList;

public interface TetrahedronPointsParser {
    ArrayList<Point> parsePoints(ArrayList<String> dataFromFile);
}
