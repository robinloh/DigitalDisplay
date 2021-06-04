package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ParserTest {

    private InputStream originalIn = System.in;

    @BeforeEach
    public void setInputStream() {
        System.setIn(originalIn);
    }

    @Test
    public void testReadEnd() {
        ByteArrayInputStream in = new ByteArrayInputStream("end".getBytes());
        System.setIn(in);

        ArrayList<String> expected = new ArrayList<>();

        Parser parser = new Parser();
        ArrayList<String> actual = parser.read(System.in);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRead1Time() {
        ByteArrayInputStream in = new ByteArrayInputStream("16:45\nend".getBytes());
        System.setIn(in);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("16:45");

        Parser parser = new Parser();
        ArrayList<String> actual = parser.read(System.in);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testRead2Time() {
        ByteArrayInputStream in = new ByteArrayInputStream("01:23\n23:45\nend".getBytes());
        System.setIn(in);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("01:23");
        expected.add("23:45");

        Parser parser = new Parser();
        ArrayList<String> actual = parser.read(System.in);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @AfterEach
    public void resetInputStream() {
        System.setIn(originalIn);
    }
}

