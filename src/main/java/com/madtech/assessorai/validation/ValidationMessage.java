package com.madtech.assessorai.validation;

public class ValidationMessage {
    private ValidationMessage() {}
    public static final String notEmpty = "cannot be empty.";
    public static final String notNull = "cannot be null.";
    public static final String maxLenStr = "character count cannot be greater than";
    public static final String minLenStr = "character count cannot be less than";
    public static final String idCannotBeFound = "with id %d cannot be found.";
}
