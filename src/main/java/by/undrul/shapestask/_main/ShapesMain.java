package by.undrul.shapestask._main;

import by.undrul.shapestask.creator.TetrahedronWarehouseCreator;
import by.undrul.shapestask.creator.impl.TetrahedronRepositoryCreatorImpl;
import by.undrul.shapestask.creator.impl.TetrahedronWarehouseCreatorImpl;
import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.exception.ShapeException;
import by.undrul.shapestask.factory.TetrahedronFactory;
import by.undrul.shapestask.factory.impl.TetrahedronFactoryImpl;
import by.undrul.shapestask.parser.impl.TetrahedronPointsParserImpl;
import by.undrul.shapestask.reader.impl.DataReaderImpl;
import by.undrul.shapestask.repository.Specification;
import by.undrul.shapestask.repository.impl.TetrahedronIdSpecification;
import by.undrul.shapestask.repository.impl.TetrahedronRepositoryImpl;
import by.undrul.shapestask.repository.impl.TetrahedronSurfaceAreaSpecification;
import by.undrul.shapestask.warehouse.TetrahedronParametr;
import by.undrul.shapestask.warehouse.TetrahedronWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ShapesMain {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        String filepath = "./src/main/resources/data/data.txt";
        DataReaderImpl dataReader = new DataReaderImpl();
        TetrahedronPointsParserImpl tetrahedrPointsParser = new TetrahedronPointsParserImpl();
        TetrahedronRepositoryCreatorImpl tetrahedronRepositoryCreator = new TetrahedronRepositoryCreatorImpl();
        TetrahedronRepositoryImpl tetrahedronRepositoryImpl;
        TetrahedronWarehouseCreator warehouseCreator = new TetrahedronWarehouseCreatorImpl();

        try {
            ArrayList<String> datafromFile = dataReader.readDataFromFile(filepath);
            ArrayList<Point> points = tetrahedrPointsParser.parsePoints(datafromFile);
            tetrahedronRepositoryImpl = tetrahedronRepositoryCreator.createTetrahedronRepository(points);


            for (Tetrahedron tetrahedron : tetrahedronRepositoryImpl.getAll()) {
                logger.info(tetrahedron);
                warehouseCreator.createTetrahedronWarehouse(tetrahedron);
                TetrahedronWarehouse warehouse = TetrahedronWarehouse.getInstance();
                TetrahedronParametr parametr = warehouse.getParametr(tetrahedron.getId());
                logger.info(parametr);
            }

            Specification specification = new TetrahedronIdSpecification(1);
            logger.info(tetrahedronRepositoryImpl.queryStream(specification));

            Specification areaSpecification = new TetrahedronSurfaceAreaSpecification(1, 10);
            logger.info(tetrahedronRepositoryImpl.queryStream(areaSpecification));

        } catch (ShapeException e) {
            e.printStackTrace();
        }
    }
}
