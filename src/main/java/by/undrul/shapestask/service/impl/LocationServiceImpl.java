package by.undrul.shapestask.service.impl;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.LocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocationServiceImpl implements LocationService {
    private static Logger logger = LogManager.getLogger();

    public LocationServiceImpl() {
    }

    @Override
    public boolean isBaseLiesOnXY(Tetrahedron tetrahedron) {
        logger.info("Method isBaseLiesOnXY start");

        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        boolean lies = false;

        if (basePoint1.getZ() == 0 && basePoint2.getZ() == 0 && basePoint3.getZ() == 0) {
            lies = true;
        }

        return lies;
    }

    @Override
    public boolean isBaseLiesOnXZ(Tetrahedron tetrahedron) {
        logger.info("Method isBaseLiesOnXZ start");

        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        boolean lies = false;

        if (basePoint1.getY() == 0 && basePoint2.getY() == 0 && basePoint3.getY() == 0) {
            lies = true;
        }

        return lies;
    }

    @Override
    public boolean isBaseLiesOnYZ(Tetrahedron tetrahedron) {
        logger.info("Method isBaseLiesOnYZ start");

        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        boolean lies = false;

        if (basePoint1.getX() == 0 && basePoint2.getX() == 0 && basePoint3.getX() == 0) {
            lies = true;
        }

        return lies;
    }
}
