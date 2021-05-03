package by.undrul.shapestask.comparator;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.impl.TetrahedronCalculateServiceImpl;

import java.util.Comparator;

public class TetrahedronVolumeComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        TetrahedronCalculateServiceImpl calculateService = new TetrahedronCalculateServiceImpl();
        double firstVolume = calculateService.calculateVolume(o1);
        double secondVolume = calculateService.calculateVolume(o2);
        int compare = Double.compare(firstVolume, secondVolume);
        return compare;
    }
}
