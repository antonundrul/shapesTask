package by.undrul.shapestask.parser;

import by.undrul.shapestask.entity.Point;

import java.util.ArrayList;

public interface TetrahedrPointsParser {
    ArrayList<Point> parsePoints(ArrayList<String> dataFromFile);
}
