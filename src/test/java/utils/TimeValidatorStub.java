package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidatorStub extends TimeValidator {

    private static final String TIME_REGEX = ".*";   // Replace with "([01]?[0-9]|2[0-3]):[0-5][0-9]"

    private final Pattern pattern;

    public TimeValidatorStub() {
        this.pattern = Pattern.compile(TIME_REGEX);
    }

    public boolean validate(String time) {
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

}