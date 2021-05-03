package by.undrul.shapestask.creator.impl;

import by.undrul.shapestask.creator.TetrahedronWarehouseCreator;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.TetrahedronCalculateService;
import by.undrul.shapestask.service.impl.TetrahedronCalculateServiceImpl;
import by.undrul.shapestask.warehouse.TetrahedronWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TetrahedronWarehouseCreatorImpl implements TetrahedronWarehouseCreator {
    private static Logger logger = LogManager.getLogger();

    public TetrahedronWarehouseCreatorImpl() {
    }

    @Override
    public TetrahedronWarehouse createTetrahedronWarehouse(Tetrahedron tetrahedron) {
        int tetrahedronId = tetrahedron.getId();

        TetrahedronCalculateService service = new TetrahedronCalculateServiceImpl();
        double volume = service.calculateVolume(tetrahedron);
        double surfaceArea = service.calculateSurfaceArea(tetrahedron);

        TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();
        warehouse.putParametr(tetrahedronId, surfaceArea, volume);

        return warehouse;
    }
}
