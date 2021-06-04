package utils;

import java.util.regex.*;

public class TimeValidator {

    private static final String TIME_REGEX = ".*";   // Replace with "([01]?[0-9]|2[0-3]):[0-5][0-9]"

    private final Pattern pattern;

    public TimeValidator() {
        this.pattern = Pattern.compile(TIME_REGEX);
    }

    public boolean validate(String time) {
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

}
