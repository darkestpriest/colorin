package org.darkestapp.colorin.structure.utils;

import org.darkestapp.colorin.structure.exceptions.ColorinLoggerException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Logger configured for Colorin
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 29/10/16.
 * @version 1.0
 */
public class ColorinLogger {

    private static final String COLORIN_LOG = "ColorinLog";
    /**
     * Logger used in this class.
     */
    private Logger logger;

    /**
     * Default constructor
     * @param filePath
     * @throws ColorinLoggerException
     */
    public ColorinLogger(String filePath) throws ColorinLoggerException {
        configLogger(filePath);
    }

    public ColorinLogger() {
        logger = Logger.getLogger(COLORIN_LOG);
    }

    /**
     * Configures the logger and the file when the log will be stored.
     * @param filePath
     * @throws ColorinLoggerException
     */
    private void configLogger(String filePath) throws ColorinLoggerException {

        this.logger = Logger.getLogger(COLORIN_LOG);
        FileHandler fileHandler;

        try {

            // This block configure the logger with handler and formatter
            fileHandler = new FileHandler(filePath);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

        } catch (SecurityException e) {
            throw new ColorinLoggerException(
                    e,
                    "Creating a ColorinLogger",
                    "A security exception has occurred");
        } catch (IOException e) {
            throw new ColorinLoggerException(
                    e,
                    "Creating a ColorinLogger",
                    "A error with the file handled as occurred");
        }

    }

    /**
     * Log an info message
     * @param message
     */
    public void info(String message){
        logger.info(message);
    }

    /**
     * Log a warning message.
     * @param message
     */
    public void debug(String message){
        logger.warning(message);
    }

}
