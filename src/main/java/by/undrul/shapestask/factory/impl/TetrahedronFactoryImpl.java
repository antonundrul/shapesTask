package by.undrul.shapestask.factory.impl;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.factory.TetrahedronFactory;
import by.undrul.shapestask.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronFactoryImpl implements TetrahedronFactory {
    private static Logger logger = LogManager.getLogger();

    public TetrahedronFactoryImpl() {
    }

    @Override
    public Tetrahedron createTetrahedron(Point apexPoint, Point basePoint1, Point basePoint2, Point basePoint3) {
        logger.info("Method to create tetrahedron start");

        int id = IdGenerator.generateId();
        Tetrahedron tetrahedron = new Tetrahedron(apexPoint, basePoint1, basePoint2, basePoint3);
        tetrahedron.setId(id);

        logger.info("Tetrahedron created");

        return tetrahedron;
    }
}
