package by.undrul.shapestask.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointsLineValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_POINTS = "(-?(0|[1-9]\\d*)(\\.\\d+)?)";
    private static final String REGEX_FOR_SPLIT = "\\s+";

    public static boolean isPointsLineValid(String line) {
        logger.info("Method to validate points line start");

        boolean isVal = false;
        String[] elements = line.split(REGEX_FOR_SPLIT);
        if (elements.length == 12) {
            for (String element : elements) {
                if (element.matches(REGEX_FOR_POINTS)) {
                    isVal = true;
                } else {
                    isVal = false;
                    logger.info("The string "+line+" has an invalid parametr");
                    break;
                }
            }
        }
        else {
            logger.info("The string "+line+" has not enough parameters "+elements.length);
        }

        return isVal;

    }
}
