package by.undrul.shapestask.creator;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.warehouse.TetrahedronWarehouse;

public interface TetrahedronWarehouseCreator {
    TetrahedronWarehouse createTetrahedronWarehouse(Tetrahedron tetrahedron);
}
