package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Log {

    private Log() {
    }

    private static Logger logger;

    public static void setNameClass(String nameClass) {
        logger = LogManager.getLogger(nameClass);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void info(String message1, String message2) {
        logger.info(String.format("%s %s", message1, message2));
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }
}

