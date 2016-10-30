package org.darkestapp.colorin.structure.exceptions;

import org.darkestapp.colorin.structure.interfaces.ColorinException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 29/10/16.
 * @Version 1.0
 */
public class ColorinLoggerException extends ColorinException {

    /**
     * Represent the default message
     */
    public static final String DEFAULT_MESSAGE = "There's an error using logger";

    /**
     * Constructor with parameters
     *
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    public ColorinLoggerException(
            final String message,
            final Exception cause,
            final String context,
            final String possibleReason) {
        super(message, cause, context, possibleReason);
    }

    /**
     * Constructor with parameters
     *
     * @param cause
     * @param context
     * @param possibleReason
     */
    public ColorinLoggerException(
            Exception cause,
            String context,
            String possibleReason) {
        super(DEFAULT_MESSAGE, cause, context, possibleReason);
    }

    /**
     * Constructor with parameters
     *
     * @param message
     * @param cause
     */
    public ColorinLoggerException(
            final String message,
            final Exception cause) {
        this(message, cause, "", "");
    }

    /**
     * Constructor with parameter
     *
     * @param message
     */
    public ColorinLoggerException(final String message) {
        this(message, null);
    }

    /**
     * Constructor with parameter
     *
     * @param exception
     */
    public ColorinLoggerException(final Exception exception) {
        this(exception.getMessage());
        setStackTrace(exception.getStackTrace());
    }

    /**
     * Constructor
     */
    public ColorinLoggerException() {
        this(DEFAULT_MESSAGE);
    }

}
