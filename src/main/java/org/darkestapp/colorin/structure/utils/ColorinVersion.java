package org.darkestapp.colorin.structure.utils;

import org.darkestapp.colorin.structure.exceptions.CannotGetPropertiesException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/10/16.
 */
public class ColorinVersion {

    public static final String CONFIG_PATH_FILE = "version.properties";
    private static final ColorinLogger logger = ColorinLogger.getColorinLogger();

    /**
     * Returns the version from properties file stored in resources
     * @return
     * @throws CannotGetPropertiesException
     */
    public static String getVersion() throws CannotGetPropertiesException {
        Properties properties = new Properties();
        FileInputStream input = null;

        try {
            ClassLoader classLoader = ColorinVersion.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(CONFIG_PATH_FILE);
            properties.load(inputStream);
            return properties.getProperty("version");
        } catch (IOException e) {
            logger.debug(e.getMessage());
            throw new CannotGetPropertiesException(
                    e,
                    "Getting version from "+CONFIG_PATH_FILE,
                    "There's is an I/O error");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new CannotGetPropertiesException(
                    e,
                    "Getting version from "+CONFIG_PATH_FILE,
                    "There's is an unexpected exception");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.debug(e.getMessage());
                    throw new CannotGetPropertiesException(
                            e,
                            "Getting version from "+CONFIG_PATH_FILE,
                            "There's is an I/O error");
                } catch (Exception e) {
                    logger.debug(e.getMessage());
                    throw new CannotGetPropertiesException(
                            e,
                            "Getting version from "+CONFIG_PATH_FILE,
                            "There's is an unexpected exception");
                }
            }
        }
    }

}
