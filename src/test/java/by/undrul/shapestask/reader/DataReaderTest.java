package by.undrul.shapestask.reader;

import by.undrul.shapestask.exception.ShapeException;
import by.undrul.shapestask.reader.impl.DataReaderImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DataReaderTest {

    @Test
    public void readDataFromFileTest() throws ShapeException {
        DataReader reader = new DataReaderImpl();
        String filepath = "./src/test/resources/data/data.txt";

        ArrayList<String> expected = new ArrayList<>();
        String str1 = "2.0 -1   1  5 5 4  3 2.0     -1  4      1  3";
        String str2 = "14 4 5   -5wrong -3 2  -2 -6 -3 -2 2 -1";
        String str3 = "14 4 5   -5 -3 2  -2 -6 -3 -2 2 -1";
        expected.add(str1);
        expected.add(str2);
        expected.add(str3);
        ArrayList<String> actual = reader.readDataFromFile(filepath);

        Assert.assertEquals(expected, actual);
    }
}
