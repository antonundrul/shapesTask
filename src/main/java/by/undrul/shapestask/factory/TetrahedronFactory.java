package by.undrul.shapestask.factory;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;

import java.util.ArrayList;

public interface TetrahedronFactory {
    Tetrahedron createTetrahedron(Point apexPoint, Point basePoint1, Point basePoint2, Point basePoint3);
    //Tetrahedron createTetrahedron(ArrayList<Point> points);
}
