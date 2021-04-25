package by.undrul.shapestask.service.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.TetrahedrCalculateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedrCalculateServiceImpl implements TetrahedrCalculateService {
    static Logger logger = LogManager.getLogger();

    public TetrahedrCalculateServiceImpl() {
    }

    @Override
    public double calculateEdge(Tetrahedron tetrahedron) {
        return 0;
    }

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) {
        double edge = calculateEdge(tetrahedron);
        double volume = Math.sqrt(2)*Math.pow(edge, 3)/12;
        return volume;
    }

    @Override
    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double edge = calculateEdge(tetrahedron);
        double surfaceArea = Math.sqrt(3)*edge;
        return surfaceArea;
    }
}
