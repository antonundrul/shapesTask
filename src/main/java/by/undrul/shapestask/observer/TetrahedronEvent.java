package by.undrul.shapestask.observer;

import by.undrul.shapestask.entity.Tetrahedron;

import java.util.EventObject;

public class TetrahedronEvent extends EventObject {
    public TetrahedronEvent(Tetrahedron source) {
        super(source);
    }

    @Override
    public Tetrahedron getSource() {
        return (Tetrahedron) super.getSource();
    }
}
