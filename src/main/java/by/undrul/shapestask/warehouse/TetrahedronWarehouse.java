package by.undrul.shapestask.warehouse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TetrahedronWarehouse {
    private static TetrahedronWarehouse instance;
    private Map<Integer,TetrahedronParametr> parametrsMap;

    private TetrahedronWarehouse(){
        parametrsMap = new HashMap<>();
    }

    public static TetrahedronWarehouse getInstance(){
        if(instance==null){
            instance = new TetrahedronWarehouse();
        }
        return instance;
    }

    public TetrahedronParametr getParametr(int key){
        return parametrsMap.get(key);
    }

    public TetrahedronParametr putParametr(Integer key, TetrahedronParametr parametr){
        return parametrsMap.put(key, parametr);
    }

    public Collection<TetrahedronParametr> parametrs(){
        return parametrsMap.values();
    }
}
