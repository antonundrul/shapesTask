package by.undrul.shapestask.validator;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.impl.DistanceServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronValidator {
    private static Logger logger = LogManager.getLogger();

    public static boolean isTetrahedronValid(Tetrahedron tetrahedron) {
        boolean isValid = false;
        DistanceServiceImpl distanceService = new DistanceServiceImpl();

        Point apexPoint = tetrahedron.getApexPoint();
        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        double baseEdge1 = distanceService.calculateDistanceBetweenPoints(basePoint1, basePoint2);
        double baseEdge2 = distanceService.calculateDistanceBetweenPoints(basePoint2, basePoint3);
        double baseEdge3 = distanceService.calculateDistanceBetweenPoints(basePoint3, basePoint1);

        //final boolean b = baseEdge1 == baseEdge2 && baseEdge2 == baseEdge3 && baseEdge3 == side1 && side1 == side2 && side2 == side3;



        if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() == basePoint3.getX() && basePoint1.getX() != apexPoint.getX()) {
            if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() != basePoint3.getY() ||
                    basePoint1.getY() == basePoint3.getY() && basePoint1.getY() != basePoint2.getY() ||
                    basePoint2.getY() == basePoint3.getY() && basePoint2.getY() != basePoint1.getY()) {

                isValid = true;
            }

            if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() != basePoint3.getZ() ||
                    basePoint1.getZ() == basePoint3.getZ() && basePoint1.getZ() != basePoint2.getZ() ||
                    basePoint2.getZ() == basePoint3.getZ() && basePoint2.getZ() != basePoint1.getZ()) {

                isValid = true;
            }
        }


        if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() == basePoint3.getY() && basePoint1.getY() != apexPoint.getY()) {
            if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() != basePoint3.getX() ||
                    basePoint1.getX() == basePoint3.getX() && basePoint1.getX() != basePoint2.getX() ||
                    basePoint2.getX() == basePoint3.getX() && basePoint2.getX() != basePoint1.getX()) {

                isValid = true;
            }

            if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() != basePoint3.getZ() ||
                    basePoint1.getZ() == basePoint3.getZ() && basePoint1.getZ() != basePoint2.getZ() ||
                    basePoint2.getZ() == basePoint3.getZ() && basePoint2.getZ() != basePoint1.getZ()) {

                isValid = true;
            }
        }


        if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() == basePoint3.getZ() && basePoint1.getZ() != apexPoint.getZ()) {
            if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() != basePoint3.getY() ||
                    basePoint1.getY() == basePoint3.getY() && basePoint1.getY() != basePoint2.getY() ||
                    basePoint2.getY() == basePoint3.getY() && basePoint2.getY() != basePoint1.getY()) {

                isValid = true;
            }

            if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() != basePoint3.getX() ||
                    basePoint1.getX() == basePoint3.getX() && basePoint1.getX() != basePoint2.getX() ||
                    basePoint2.getX() == basePoint3.getX() && basePoint2.getX() != basePoint1.getX()) {

                isValid = true;
            }
        }


        if (baseEdge1 == 0 || baseEdge2 == 0 || baseEdge3 == 0) {
            isValid = false;
        }

        return isValid;
    }


}
