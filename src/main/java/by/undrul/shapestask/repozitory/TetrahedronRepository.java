package by.undrul.shapestask.repozitory;

import by.undrul.shapestask.entity.Tetrahedron;

import java.util.ArrayList;

public class TetrahedronRepository {
    private ArrayList<Tetrahedron> tetrahedrons;
    private static TetrahedronRepository instance;

    private TetrahedronRepository() {
        tetrahedrons = new ArrayList<>();
    }

    public static TetrahedronRepository getInstance() {
        if (instance == null) {
            instance = new TetrahedronRepository();
        }
        return instance;
    }

    public void add(Tetrahedron tetrahedron){
        tetrahedrons.add(tetrahedron);
    }

    public void remove(Tetrahedron tetrahedron){
        tetrahedrons.remove(tetrahedron);
    }

    public Tetrahedron getTetrahedron(int index){
        return tetrahedrons.get(index);
    }

    public ArrayList<Tetrahedron> getAll(){
        return tetrahedrons;
    }

}
