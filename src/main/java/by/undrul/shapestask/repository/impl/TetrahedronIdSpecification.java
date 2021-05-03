package by.undrul.shapestask.repository.impl;

import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.repository.Specification;

public class TetrahedronIdSpecification implements Specification {
    private int id;

    public TetrahedronIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specifyTetrahedron(Tetrahedron tetrahedron) {
        boolean result = tetrahedron.getId() == id;
        return result;
    }
}
