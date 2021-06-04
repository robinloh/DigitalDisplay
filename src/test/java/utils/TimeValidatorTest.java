package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeValidatorTest {

    @Test
    public void testValidateValid1459() {
        TimeValidator timeValidator = new TimeValidator();
        boolean actual = timeValidator.validate("14:59");
        assertTrue(actual);
    }

    @Test
    public void testValidateValid0837() {
        TimeValidator timeValidator = new TimeValidator();
        boolean actual = timeValidator.validate("08:37");
        assertTrue(actual);
    }

    @Test
    public void testValidateValid2000() {
        TimeValidator timeValidator = new TimeValidator();
        boolean actual = timeValidator.validate("20:00");
        assertTrue(actual);
    }
}