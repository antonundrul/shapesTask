package by.undrul.shapestask.repository;

import by.undrul.shapestask.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface TetrahedronRepository {
    void add(Tetrahedron tetrahedron);

    void remove(Tetrahedron tetrahedron);

    Optional<Tetrahedron> getTetrahedron(int index);

    ArrayList<Tetrahedron> getAll();

    ArrayList<Tetrahedron> query(Specification specification);

    List<Tetrahedron> queryStream(Specification specification);

    ArrayList<Tetrahedron> sort(Comparator<? super Tetrahedron> comparator);
}
