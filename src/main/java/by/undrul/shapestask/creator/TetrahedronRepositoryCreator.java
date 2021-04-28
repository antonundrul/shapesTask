package by.undrul.shapestask.creator;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.repozitory.impl.TetrahedronRepositoryImpl;

import java.util.ArrayList;

public interface TetrahedronRepositoryCreator {
    TetrahedronRepositoryImpl createTetrahedronRepository(ArrayList<Point> points);
}
