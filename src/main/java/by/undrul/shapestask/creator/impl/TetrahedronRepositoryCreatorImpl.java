package by.undrul.shapestask.creator.impl;

import by.undrul.shapestask.creator.TetrahedronRepositoryCreator;
import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.factory.impl.TetrahedronFactoryImpl;
import by.undrul.shapestask.repository.impl.TetrahedronRepositoryImpl;
import by.undrul.shapestask.validator.TetrahedronValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class TetrahedronRepositoryCreatorImpl implements TetrahedronRepositoryCreator {
    private static Logger logger = LogManager.getLogger();
    private static final int TETRAHEDRON_NUMBER_OF_POINTS = 4;

    public TetrahedronRepositoryCreatorImpl() {
    }

    @Override
    public TetrahedronRepositoryImpl createTetrahedronRepository(ArrayList<Point> points) {
        logger.info("Method to create tetrahedron repository by points start");
        TetrahedronRepositoryImpl tetrahedronRepositoryImpl = TetrahedronRepositoryImpl.getInstance();
        TetrahedronFactoryImpl tetrahedronFactory = new TetrahedronFactoryImpl();

        int size = points.size();
        int numberOfIncorrectFigures = 0;
        for (int i = 0; i < size; i += TETRAHEDRON_NUMBER_OF_POINTS) {
            Point apexPoint = points.get(i);
            Point basePoint1 = points.get(i + 1);
            Point basePoint2 = points.get(i + 2);
            Point basePoint3 = points.get(i + 3);
            Tetrahedron tetrahedron = tetrahedronFactory.createTetrahedron(apexPoint, basePoint1, basePoint2, basePoint3);
            if (TetrahedronValidator.isTetrahedronValid(tetrahedron)) {
                tetrahedronRepositoryImpl.add(tetrahedron);
                logger.info("Tetrahedron with id = " + tetrahedron.getId() + " added to repository");
            } else {
                numberOfIncorrectFigures++;
                logger.error("The figure with id = " + tetrahedron.getId() + " is not a tetrahedron");
            }
        }

        logger.info("Tetrahedron repository created without " + numberOfIncorrectFigures + " figures");

        return tetrahedronRepositoryImpl;
    }
}
