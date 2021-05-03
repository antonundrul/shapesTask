package by.undrul.shapestask.repository.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.repository.Specification;
import by.undrul.shapestask.service.TetrahedronCalculateService;
import by.undrul.shapestask.service.impl.TetrahedronCalculateServiceImpl;

public class TetrahedronSurfaceAreaSpecification implements Specification {
    private double maxArea;
    private double minArea;

    public TetrahedronSurfaceAreaSpecification(double maxArea, double minArea) {
        this.maxArea = maxArea;
        this.minArea = minArea;
    }

    @Override
    public boolean specifyTetrahedron(Tetrahedron tetrahedron) {
        TetrahedronCalculateService calculateService = new TetrahedronCalculateServiceImpl();
        double area = calculateService.calculateSurfaceArea(tetrahedron);

        boolean result = area >= minArea && area <= maxArea;
        return result;
    }
}
