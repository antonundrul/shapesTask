package by.undrul.shapestask.parser.impl;

import by.undrul.shapestask.parser.TetrahedronPointsParser;
import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.factory.impl.PointFactoryImpl;
import by.undrul.shapestask.validator.PointsLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TetrahedronPointsParserImpl implements TetrahedronPointsParser {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_SPLIT = "\\s+";

    public TetrahedronPointsParserImpl() {
    }

    @Override
    public ArrayList<Point> parsePoints(ArrayList<String> dataFromFile) {
        logger.info("Method to parse data from file start");

        ArrayList<Point> points = new ArrayList<>();
        PointFactoryImpl pointFactory = new PointFactoryImpl();

        for (String line : dataFromFile) {
            if (PointsLineValidator.isPointsLineValid(line)) {
                String[] pointsLine = line.split(REGEX_FOR_SPLIT);
                for (int i = 0; i < pointsLine.length; i += 3) {
                    double x = Double.parseDouble(pointsLine[i]);
                    double y = Double.parseDouble(pointsLine[i + 1]);
                    double z = Double.parseDouble(pointsLine[i + 2]);
                    Point point = pointFactory.createPoint(x, y, z);
                    points.add(point);
                }
            }

        }

        return points;
    }
}
