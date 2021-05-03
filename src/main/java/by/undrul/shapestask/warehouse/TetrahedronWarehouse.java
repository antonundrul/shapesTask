package by.undrul.shapestask.warehouse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TetrahedronWarehouse {
    private static TetrahedronWarehouse instance;
    private Map<Integer, TetrahedronParametr> parametrsMap;

    private TetrahedronWarehouse() {
        parametrsMap = new HashMap<>();
    }

    public static TetrahedronWarehouse getInstance() {
        if (instance == null) {
            instance = new TetrahedronWarehouse();
        }
        return instance;
    }

    public TetrahedronParametr getParametr(int key) {
        return parametrsMap.get(key);
    }

    public TetrahedronParametr putParametr(Integer key, double surfaceArea, double volume) {
        TetrahedronParametr parametr = new TetrahedronParametr(surfaceArea, volume);

        return parametrsMap.put(key, parametr);
    }

    public TetrahedronParametr removeParametr(int key) {
        TetrahedronParametr parametr = parametrsMap.remove(key);
        return parametr;
    }

    public Collection<TetrahedronParametr> parametrs() {
        return parametrsMap.values();
    }
}
