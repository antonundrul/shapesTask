package by.undrul.shapestask.service;

import by.undrul.shapestask.entity.Tetrahedron;

public interface TetrahedronCalculateService {

    double calculateVolume(Tetrahedron tetrahedron);

    double calculateSurfaceArea(Tetrahedron tetrahedron);

    double calculateHeight(Tetrahedron tetrahedron);

    double calculateBaseArea(Tetrahedron tetrahedron);

    double calculateBasePerimeter(Tetrahedron tetrahedron);
}
