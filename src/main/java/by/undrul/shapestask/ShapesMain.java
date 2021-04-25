package by.undrul.shapestask;

import by.undrul.shapestask.creator.impl.TetrahedronRepositoryCreatorImpl;
import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.exception.ShapeException;
import by.undrul.shapestask.parser.impl.TetrahedronPointsParserImpl;
import by.undrul.shapestask.reader.impl.DataReaderImpl;
import by.undrul.shapestask.repozitory.TetrahedronRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ShapesMain {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        DataReaderImpl dataReader = new DataReaderImpl();
        TetrahedronPointsParserImpl tetrahedrPointsParser = new TetrahedronPointsParserImpl();
        TetrahedronRepositoryCreatorImpl tetrahedronRepositoryCreator = new TetrahedronRepositoryCreatorImpl();
        TetrahedronRepository tetrahedronRepository;;

        try {
            ArrayList<String> datafromFile = dataReader.readDataFromFile("./src/main/resources/data/data.txt");
            ArrayList<Point> points = tetrahedrPointsParser.parsePoints(datafromFile);
            tetrahedronRepository=tetrahedronRepositoryCreator.createTetrahedronRepository(points);

            logger.info(tetrahedronRepository.getAll());
        } catch (ShapeException e) {
            e.printStackTrace();
        }
    }
}
