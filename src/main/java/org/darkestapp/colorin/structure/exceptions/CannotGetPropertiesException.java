package org.darkestapp.colorin.structure.exceptions;

import org.darkestapp.colorin.structure.interfaces.ColorinException;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/10/16.
 */
public class CannotGetPropertiesException extends ColorinException {
    /**
     * Represent the default message
     */
    public static final String DEFAULT_MESSAGE = "There's an error get properties from file";

    /**
     * Constructor with parameters
     *
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    public CannotGetPropertiesException(
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
    public CannotGetPropertiesException(
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
    public CannotGetPropertiesException(
            final String message,
            final Exception cause) {
        this(message, cause, "", "");
    }

    /**
     * Constructor with parameter
     *
     * @param message
     */
    public CannotGetPropertiesException(final String message) {
        this(message, null);
    }

    /**
     * Constructor with parameter
     *
     * @param exception
     */
    public CannotGetPropertiesException(final Exception exception) {
        this(exception.getMessage());
        setStackTrace(exception.getStackTrace());
    }

    /**
     * Constructor
     */
    public CannotGetPropertiesException() {
        this(DEFAULT_MESSAGE);
    }
}
