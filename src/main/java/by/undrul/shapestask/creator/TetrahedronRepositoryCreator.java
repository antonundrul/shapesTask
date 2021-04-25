package by.undrul.shapestask.creator;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.repozitory.TetrahedronRepository;

import java.util.ArrayList;

public interface TetrahedronRepositoryCreator {
    TetrahedronRepository createTetrahedronRepository(ArrayList<Point> points);
}
