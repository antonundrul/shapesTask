package by.undrul.shapestask;

import by.undrul.shapestask.creator.impl.TetrahedronRepositoryCreatorImpl;
import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.exception.ShapeException;
import by.undrul.shapestask.parser.impl.TetrahedronPointsParserImpl;
import by.undrul.shapestask.reader.impl.DataReaderImpl;
import by.undrul.shapestask.repozitory.impl.TetrahedronRepositoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ShapesMain {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        DataReaderImpl dataReader = new DataReaderImpl();
        TetrahedronPointsParserImpl tetrahedrPointsParser = new TetrahedronPointsParserImpl();
        TetrahedronRepositoryCreatorImpl tetrahedronRepositoryCreator = new TetrahedronRepositoryCreatorImpl();
        TetrahedronRepositoryImpl tetrahedronRepositoryImpl;;

        try {
            ArrayList<String> datafromFile = dataReader.readDataFromFile("./src/main/resources/data/data.txt");
            ArrayList<Point> points = tetrahedrPointsParser.parsePoints(datafromFile);
            tetrahedronRepositoryImpl =tetrahedronRepositoryCreator.createTetrahedronRepository(points);

            logger.info(tetrahedronRepositoryImpl.getAll());
        } catch (ShapeException e) {
            e.printStackTrace();
        }
    }
}
