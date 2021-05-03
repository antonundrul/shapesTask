package by.undrul.shapestask.observer.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.observer.TetrahedronEvent;
import by.undrul.shapestask.service.impl.TetrahedronCalculateServiceImpl;
import by.undrul.shapestask.warehouse.TetrahedronWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronObserverImpl implements by.undrul.shapestask.observer.TetrahedronObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void changeParameters(TetrahedronEvent event) {
        Tetrahedron tetrahedron = event.getSource();
        TetrahedronCalculateServiceImpl service = new TetrahedronCalculateServiceImpl();
        TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();

        int tetrahedronId = tetrahedron.getId();
        double volume = service.calculateVolume(tetrahedron);
        double surfaceArea = service.calculateSurfaceArea(tetrahedron);
        warehouse.putParametr(tetrahedronId, surfaceArea, volume);

    }
}
