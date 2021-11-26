package io.jking.tickster.interaction.impl.slash.core.type;

public enum ErrorType {

    UNKNOWN("An unknown error occurred."),
    CUSTOM("%s"),
    PERMISSION("%s is missing the required permission(s): %s."),
    CANT_INTERACT("%s cannot interact with %s."),
    CANT_ACCESS("%s cannot access the following channel: %s."),
    INVALID_ID("The ID you provided is invalid."),
    ARGS("You provided invalid arguments. %s"),
    SELECTION("An error occurred with your selection. %s"),
    RETRIEVING("An error occurred retrieving %s.");

    private final String errorResponse;

    ErrorType(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public String getName() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
