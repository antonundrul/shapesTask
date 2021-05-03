package by.undrul.shapestask.repository.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.repository.Specification;
import by.undrul.shapestask.service.TetrahedronCalculateService;
import by.undrul.shapestask.service.impl.TetrahedronCalculateServiceImpl;

public class TetrahedronVolumeSpecification implements Specification {
    private double minVolume;
    private double maxVolume;

    public TetrahedronVolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specifyTetrahedron(Tetrahedron tetrahedron) {
        TetrahedronCalculateService calculateService = new TetrahedronCalculateServiceImpl();
        double volume = calculateService.calculateVolume(tetrahedron);

        boolean result = volume >= minVolume && volume <= maxVolume;

        return result;
    }
}
