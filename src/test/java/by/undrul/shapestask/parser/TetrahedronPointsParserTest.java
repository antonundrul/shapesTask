package by.undrul.shapestask.parser;

import by.undrul.shapestask.entity.Point;
import by.undrul.shapestask.parser.impl.TetrahedronPointsParserImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TetrahedronPointsParserTest {

    @Test
    public void testParsePoints() {
        TetrahedronPointsParser parser = new TetrahedronPointsParserImpl();
        ArrayList<String> coordinates = new ArrayList<>();
        String actualString = "3.0   1.0   0    -1.0   1.0   5    -1.0  -2.2   0     1.0   -3.0 0  ";
        coordinates.add(actualString);
        ArrayList<Point> expected = new ArrayList<>();
        Point point1 = new Point(3.0, 1.0, 0);
        Point point2 = new Point(-1.0, 1.0, 5);
        Point point3 = new Point(-1.0, -2.2, 0);
        Point point4 = new Point(1.0, -3.0, 0);
        expected.add(point1);
        expected.add(point2);
        expected.add(point3);
        expected.add(point4);
        ArrayList<Point> actual = parser.parsePoints(coordinates);
        Assert.assertEquals(expected, actual);
    }
}
