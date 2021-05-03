package by.undrul.shapestask.repozitory;

import by.undrul.shapestask.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.Comparator;

public interface TetrahedronRepository {
    void add(Tetrahedron tetrahedron);

    void remove(Tetrahedron tetrahedron);

    Tetrahedron getTetrahedron(int index);

    ArrayList<Tetrahedron> getAll();

    ArrayList<Tetrahedron> sort(Comparator<? super Tetrahedron> comparator);
}
