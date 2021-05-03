package by.undrul.shapestask.comparator;

import by.undrul.shapestask.entity.Tetrahedron;

import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron> {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        int compare = Integer.compare(o1.getId(), o2.getId());
        return compare;
    }
}
