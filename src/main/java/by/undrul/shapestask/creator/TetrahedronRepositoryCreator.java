package by.undrul.shapestask.creator;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.repository.impl.TetrahedronRepositoryImpl;

import java.util.ArrayList;

public interface TetrahedronRepositoryCreator {
    TetrahedronRepositoryImpl createTetrahedronRepository(ArrayList<Point> points);
}
