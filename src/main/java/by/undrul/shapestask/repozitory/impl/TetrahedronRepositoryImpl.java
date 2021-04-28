package by.undrul.shapestask.repozitory.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.repozitory.TetrahedronRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
    private ArrayList<Tetrahedron> tetrahedrons;
    private static TetrahedronRepositoryImpl instance;

    private TetrahedronRepositoryImpl() {
        tetrahedrons = new ArrayList<>();
    }

    public static TetrahedronRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TetrahedronRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(Tetrahedron tetrahedron){
        tetrahedrons.add(tetrahedron);
    }

    @Override
    public void remove(Tetrahedron tetrahedron){
        tetrahedrons.remove(tetrahedron);
    }

    @Override
    public Tetrahedron getTetrahedron(int index){
        return tetrahedrons.get(index);
    }

    @Override
    public ArrayList<Tetrahedron> getAll(){
        return tetrahedrons;
    }

    @Override
    public ArrayList<Tetrahedron> sort(Comparator<? super Tetrahedron> comparator) {
       ArrayList<Tetrahedron> result = (ArrayList<Tetrahedron>) tetrahedrons.stream().sorted(comparator).collect(Collectors.toList());
        return result;
    }

}
