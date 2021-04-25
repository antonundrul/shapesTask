package by.undrul.shapestask.service;

import by.undrul.shapestask.entity.Tetrahedron;

public interface TetrahedrCalculateService {
    double calculateEdge(Tetrahedron tetrahedron);

    double calculateVolume(Tetrahedron tetrahedron);

    double calculateSurfaceArea(Tetrahedron tetrahedron);
}
