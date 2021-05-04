package by.undrul.shapestask.validator;

import org.junit.Assert;
import org.junit.Test;

public class PointsLineValidatorTest {

    @Test
    public void isPointsLineValidTest() {
        String wrongLine = "3.0   1.0   0    -1.0   1.0   5    -1.0  -2.2   0     1.0   -3.0  0 ";
        boolean actual = PointsLineValidator.isPointsLineValid(wrongLine);
        boolean expected = true;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPointsLineValidTestWithIncorrectNumberOfCoordinates() {
        String wrongLine = "3.0   1.0   0    -1.0   1.0   5    -1.0  -2.2   0     1.0   -3.0   ";
        boolean actual = PointsLineValidator.isPointsLineValid(wrongLine);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPointsLineValidTestWithIncorrectRegex() {
        String wrongLine = "3.0  , 1.0   0    -1.0,   1.0   5    -1.0,  -2.2   0     1.0   -3.0   ";
        boolean actual = PointsLineValidator.isPointsLineValid(wrongLine);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isPointsLineValidTestWithIncorrectCoordinate() {
        String wrongLine = "3.0  , 1.0   0    coordinateZ,   1.0   5    -1.0,  -2.2   0     1.0   -3.0   ";
        boolean actual = PointsLineValidator.isPointsLineValid(wrongLine);
        boolean expected = false;

        Assert.assertEquals(expected, actual);
    }
}
