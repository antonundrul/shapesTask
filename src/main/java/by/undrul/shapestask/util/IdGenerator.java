package by.undrul.shapestask.util;

public class IdGenerator {
    private static int counter;

    static {
        counter = 0;
    }

    public static int generateId() {
        counter++;
        return counter;
    }
}
