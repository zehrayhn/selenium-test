package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.internal.LogManagerStatus;


public class Log {
    private static  Logger logger = LogManager.getLogger();

    static {
        Configurator.initialize(null, "log4j2.xml"); // log4j2.xml dosyasının yolu
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

}
