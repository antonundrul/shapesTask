package by.undrul.shapestask.repository.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.repository.Specification;
import by.undrul.shapestask.repository.TetrahedronRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
    private ArrayList<Tetrahedron> tetrahedrons;
    private static TetrahedronRepositoryImpl instance;

    public static TetrahedronRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TetrahedronRepositoryImpl();
        }
        return instance;
    }

    private TetrahedronRepositoryImpl() {
        tetrahedrons = new ArrayList<>();
    }

    @Override
    public void add(Tetrahedron tetrahedron) {
        tetrahedrons.add(tetrahedron);
    }

    @Override
    public void remove(Tetrahedron tetrahedron) {
        tetrahedrons.remove(tetrahedron);
    }

    @Override
    public Optional<Tetrahedron> getTetrahedron(int index) {
        Tetrahedron tetrahedron = tetrahedrons.get(index);
        return tetrahedron==null?Optional.empty():Optional.of(tetrahedron);
    }

    @Override
    public ArrayList<Tetrahedron> getAll() {
        return tetrahedrons;
    }

    @Override
    public ArrayList<Tetrahedron> query(Specification specification) {
        ArrayList<Tetrahedron> result = new ArrayList<>();
        for (Tetrahedron tetrahedron : tetrahedrons) {
            if (specification.specifyTetrahedron(tetrahedron)) {
                result.add(tetrahedron);
            }
        }
        return result;
    }

    @Override
    public List<Tetrahedron> queryStream(Specification specification) {
        return tetrahedrons.stream().filter(specification::specifyTetrahedron).collect(Collectors.toList());
    }

    @Override
    public ArrayList<Tetrahedron> sort(Comparator<? super Tetrahedron> comparator) {
        ArrayList<Tetrahedron> result = (ArrayList<Tetrahedron>) tetrahedrons.stream().sorted(comparator).collect(Collectors.toList());
        return result;
    }

}
