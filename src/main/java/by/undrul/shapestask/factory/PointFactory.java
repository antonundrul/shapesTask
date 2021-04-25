package by.undrul.shapestask.factory;

import by.undrul.shapestask.entity.Point;

public interface PointFactory {
    public Point createPoint(double x,double y, double z);
}
