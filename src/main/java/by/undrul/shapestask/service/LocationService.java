package by.undrul.shapestask.service;

import by.undrul.shapestask.entity.Tetrahedron;

public interface LocationService {
    boolean isBaseLiesOnXY(Tetrahedron tetrahedron);

    boolean isBaseLiesOnXZ(Tetrahedron tetrahedron);

    boolean isBaseLiesOnYZ(Tetrahedron tetrahedron);
}
