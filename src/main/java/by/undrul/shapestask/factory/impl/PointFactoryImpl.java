package by.undrul.shapestask.factory.impl;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.factory.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PointFactoryImpl implements PointFactory {
    private static Logger logger = LogManager.getLogger();

    public PointFactoryImpl() {
    }

    @Override
    public Point createPoint(double x, double y, double z) {
        logger.info("Method to create point start");
        Point point = new Point(x, y, z);
        logger.info("Point created");

        return point;
    }
}
