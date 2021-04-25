package by.undrul.shapestask.service.impl;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.service.DistanceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DistanceServiceImpl implements DistanceService {
    private static Logger logger = LogManager.getLogger();

    public DistanceServiceImpl() {
    }

    @Override
    public double calculateDistanceBetweenPoints(Point a, Point b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        double z = a.getZ() - b.getZ();

        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

        return distance;

    }
}
