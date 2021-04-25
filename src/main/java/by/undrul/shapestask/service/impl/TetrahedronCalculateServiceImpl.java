package by.undrul.shapestask.service.impl;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.entity.Tetrahedron;
import by.undrul.shapestask.service.TetrahedronCalculateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronCalculateServiceImpl implements TetrahedronCalculateService {
    static Logger logger = LogManager.getLogger();

    public TetrahedronCalculateServiceImpl() {
    }

    @Override
    public double calculateVolume(Tetrahedron tetrahedron) {
        logger.info("Method to calculate volume of tetrahedron start");
        double height = calculateHeight(tetrahedron);
        double baseArea = calculateBaseArea(tetrahedron);
        double volume = height*baseArea/3;
        logger.info("Volume of tetrahedron with id="+tetrahedron.getId()+" : "+volume);
        return volume;
    }

    @Override
    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        logger.info("Method to calculate surface area of tetrahedron start");

        Point apexPoint = tetrahedron.getApexPoint();
        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        double area1=calculateFaceArea(apexPoint,basePoint1,basePoint2);
        double area2=calculateFaceArea(apexPoint,basePoint2,basePoint3);
        double area3=calculateFaceArea(apexPoint,basePoint3,basePoint1);
        double baseArea = calculateBaseArea(tetrahedron);

        double surfaceArea = area1+area2+area3+baseArea;

        return surfaceArea;
    }

    @Override
    public double calculateHeight(Tetrahedron tetrahedron) {
        logger.info("Method to calculate height of tetrahedron start");
        Point apexPoint = tetrahedron.getApexPoint();
        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        double height = 0;

        if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() == basePoint3.getX()) {
            height = Math.abs(apexPoint.getX() - basePoint1.getX());
        }
        if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() == basePoint3.getY()) {
            height = Math.abs(apexPoint.getY() - basePoint1.getY());
        }
        if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() == basePoint3.getZ()) {
            height = Math.abs(apexPoint.getZ() - basePoint1.getZ());
        }

        logger.info("Height of tetrahedron with id="+tetrahedron.getId()+" : "+height);
        return height;
    }

    @Override
    public double calculateBasePerimeter(Tetrahedron tetrahedron) {
        logger.info("Method to calculate base perimeter of tetrahedron start");

        DistanceServiceImpl distanceService = new DistanceServiceImpl();

        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        double baseEdge1 = distanceService.calculateDistanceBetweenPoints(basePoint1, basePoint2);
        double baseEdge2 = distanceService.calculateDistanceBetweenPoints(basePoint2, basePoint3);
        double baseEdge3 = distanceService.calculateDistanceBetweenPoints(basePoint3, basePoint1);

        double perimeter = baseEdge1 + baseEdge2 + baseEdge3;

        logger.info("Base perimeter of tetrahedron with id="+tetrahedron.getId()+" : "+perimeter);
        return perimeter;
    }

    @Override
    public double calculateBaseArea(Tetrahedron tetrahedron) {
        logger.info("Method to calculate base area of tetrahedron start");

        Point basePoint1 = tetrahedron.getBasePoint1();
        Point basePoint2 = tetrahedron.getBasePoint2();
        Point basePoint3 = tetrahedron.getBasePoint3();

        double area = calculateFaceArea(basePoint1,basePoint2,basePoint3);

        logger.info("Base area of tetrahedron with id="+tetrahedron.getId()+" : "+area);
        return area;
    }

    private double calculateFaceArea(Point point1, Point point2, Point point3){
        DistanceServiceImpl distanceService = new DistanceServiceImpl();

        double edge1 = distanceService.calculateDistanceBetweenPoints(point1, point2);
        double edge2 = distanceService.calculateDistanceBetweenPoints(point2, point3);
        double edge3 = distanceService.calculateDistanceBetweenPoints(point3, point1);

        double p = (edge1+edge2+edge3)/2;

        double area = Math.sqrt(p*(p-edge1)*(p-edge2)*(p-edge3));

        return area;
    }
}
