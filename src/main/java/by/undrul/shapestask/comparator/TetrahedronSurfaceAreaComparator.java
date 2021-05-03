package by.undrul.shapestask.comparator;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.impl.TetrahedronCalculateServiceImpl;

import java.util.Comparator;

public class TetrahedronSurfaceAreaComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        TetrahedronCalculateServiceImpl calculateService = new TetrahedronCalculateServiceImpl();
        double firstArea = calculateService.calculateSurfaceArea(o1);
        double secondArea = calculateService.calculateSurfaceArea(o2);
        int compare = Double.compare(firstArea, secondArea);
        return compare;
    }
}
