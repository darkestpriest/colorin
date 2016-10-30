package org.darkestapp.colorin.structure.interfaces;

/**
 * This is the base exception class to use in this project.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 29/10/16.
 * @version 1.0
 */
public class ColorinException extends Exception {

    private final String exceptionName;
    private final ColorinException cause;
    private final String context;
    private final String possibleReason;
    private final Integer depth;

    public static final String CONTEXT_CONTENT_SEPARATOR = "&&";

    /**
     * Private contructor.
     * @param exceptionName
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    private ColorinException(
            final String exceptionName,
            final String message,
            final Exception cause,
            final String context,
            final String possibleReason) {
        super(message, cause);
        this.exceptionName = exceptionName;

        if(cause != null) {
            if(cause instanceof ColorinException) {
                this.cause = (ColorinException) cause;
            } else {
                this.cause = wrapException(cause);
            }
        } else {
            this.cause = null;
        }

        if(context == null || context.isEmpty()) {
            this.context = "N/A";
        } else {
            this.context = context;
        }

        if(possibleReason == null || possibleReason.isEmpty()) {
            this.possibleReason = "N/A";
        } else {
            this.possibleReason = possibleReason;
        }

        if(this.cause == null) {
            this.depth = Integer.valueOf(1);
        } else {
            this.depth = Integer.valueOf(this.cause.getDepth() + 1);
        }
    }

    /**
     * Default constructor.
     * @param message
     * @param cause
     * @param context
     * @param possibleReason
     */
    public ColorinException(
            final String message,
            final Exception cause,
            final String context,
            final String possibleReason) {
        super(message, cause);
        this.exceptionName = getClass().toString();

        if(cause != null) {
            if(cause instanceof ColorinException) {
                this.cause = (ColorinException) cause;
            } else {
                this.cause = wrapException(cause);
            }
        } else {
            this.cause = null;
        }

        if(context == null || context.isEmpty()) {
            this.context = "N/A";
        } else {
            this.context = context;
        }

        if(possibleReason == null || possibleReason.isEmpty()) {
            this.possibleReason = "N/A";
        } else {
            this.possibleReason = possibleReason;
        }

        if(this.cause == null) {
            this.depth = Integer.valueOf(1);
        } else {
            this.depth = Integer.valueOf(this.cause.getDepth() + 1);
        }
    }

    /**
     * This method wraps an exception and adjusts to ColorinException template
     * @param exception
     * @return
     */
    private ColorinException wrapException(final Exception exception){
        if(exception instanceof ColorinException) {
            return (ColorinException) exception;
        }
        ColorinException fermatException = new ColorinException(
                exception.getClass().toString(),
                exception.getMessage(),
                null,
                "External Colorin exception",
                "Please, review the stacktrace");
        fermatException.setStackTrace(exception.getStackTrace());
        return fermatException;
    }

    /**
     * Returns the exception cause.
     * @return
     */
    @Override
    public ColorinException getCause(){
        return cause;
    }

    /**
     * Returns the context.
     * @return
     */
    public String getContext(){
        return context;
    }

    /**
     * Returns the possible reason.
     * @return
     */
    public String getPossibleReason(){
        return possibleReason;
    }

    /**
     * Returns the exception depth.
     * @return
     */
    public int getDepth(){
        return depth.intValue();
    }

    /**
     * Returns the formatted context
     * @return
     */
    public String getFormattedContext() {
        StringBuilder builder = new StringBuilder("");
        for(String contextPart : context.split(CONTEXT_CONTENT_SEPARATOR))
            if(!contextPart.isEmpty())
                builder.append(contextPart).append("\n");
        return builder.toString();
    }

    /**
     * Returns the formatted trace.
     * @return
     */
    public String getFormattedTrace() {
        StringBuilder builder = new StringBuilder();
        for(StackTraceElement element : getStackTrace()) {
            builder.append("Class: ")
                    .append(element.getClassName())
                    .append(" - Line: ")
                    .append(element.getLineNumber())
                    .append("\n");
        }

        return builder.toString();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if(cause != null) {
            builder.append(cause.toString());

            builder.append("Exception Number: ").append(depth.toString()).append("\n");
            builder.append("Exception Type: ").append(exceptionName).append("\n");
            builder.append("Exception Message: ").append(getMessage()).append("\n");
            builder.append("Exception Possible Cause: ");
            builder.append(getPossibleReason()).append("\n");
            builder.append("Exception Context: ");
            builder.append("\n---------------------------------------------------------------------------------\n");
            builder.append(getFormattedContext());
            builder.append("---------------------------------------------------------------------------------\n");

        } else {

            builder.append("Exception Number: ").append(depth.toString()).append("\n");
            builder.append("Exception Type: ").append(exceptionName).append("\n");
            builder.append("Exception Message: ").append(getMessage()).append("\n");
            builder.append("Exception Possible Cause: ");
            builder.append(getPossibleReason()).append("\n");
            builder.append("Exception Context: ");
            builder.append("\n---------------------------------------------------------------------------------\n");
            builder.append(getFormattedContext());
            builder.append("---------------------------------------------------------------------------------\n");
            builder.append("Exception Stack Trace: \n");
            builder.append("---------------------------------------------------------------------------------\n");
            builder.append(getFormattedTrace());
            builder.append("---------------------------------------------------------------------------------\n");

        }

        return builder.toString();
    }

}
