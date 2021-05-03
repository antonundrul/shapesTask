package by.undrul.shapestask.factory;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;

public interface TetrahedronFactory {
    Tetrahedron createTetrahedron(Point apexPoint, Point basePoint1, Point basePoint2, Point basePoint3);
}
