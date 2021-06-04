package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class DigitalPrinterTest extends DigitalPrinter {

    private DigitalPrinter digitalPrinter;

    @BeforeEach
    public void initialise() {
        DigitalCharactersStub digitalCharactersStub = new DigitalCharactersStub();
        TimeValidatorStub timeValidatorStub = new TimeValidatorStub();
        this.digitalPrinter = new DigitalPrinter(digitalCharactersStub, timeValidatorStub);
    }

    @Test
    public void testPrintDigitalDisplay() {

        ArrayList<String> input = new ArrayList<>();
        input.add("16:47");
        input.add("23:59");
        input.add("00:08");

        ArrayList<String[]> expected = new ArrayList<>();

        String[] time1647 = new String[] {
                "    +  +---+     +   +  +---+",
                "    |  |         |   |      |",
                "    |  |      o  |   |      |",
                "    +  +---+     +---+      +",
                "    |  |   |  o      |      |",
                "    |  |   |         |      |",
                "    +  +---+         +      +",
                "",
                ""
        };

        String[] time2359 = new String[] {
                "+---+  +---+     +---+  +---+",
                "    |      |     |      |   |",
                "    |      |  o  |      |   |",
                "+---+  +---+     +---+  +---+",
                "|          |  o      |      |",
                "|          |         |      |",
                "+---+  +---+     +---+  +---+",
                "",
                "",
        };

        String[] time0008 = new String[] {
                "+---+  +---+     +---+  +---+",
                "|   |  |   |     |   |  |   |",
                "|   |  |   |  o  |   |  |   |",
                "+   +  +   +     +   +  +---+",
                "|   |  |   |  o  |   |  |   |",
                "|   |  |   |     |   |  |   |",
                "+---+  +---+     +---+  +---+",
                "",
                "",
        };

        String[] endLine = new String[] {"end"};
        expected.add(time1647);
        expected.add(time2359);
        expected.add(time0008);
        expected.add(endLine);

        ArrayList<String[]> actual = digitalPrinter.printDigitalDisplay(input);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void testPrintTime() {
        String[] expected = new String[] {
                "+---+  +---+     +---+  +---+",
                "    |      |     |      |   |",
                "    |      |  o  |      |   |",
                "+---+  +---+     +---+  +---+",
                "|          |  o      |      |",
                "|          |         |      |",
                "+---+  +---+     +---+  +---+",
                null,
                null,
        };

        String[] actual = digitalPrinter.printTime("23:59");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPrintCharByLine() {
        String expected = "+---+";
        String actual = digitalPrinter.printCharByLine('2', 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testPrintLinesAfterTime() {

        String[] expected = new String[] {
                "+---+  +---+     +---+  +---+",
                "|   |  |   |     |   |  |   |",
                "|   |  |   |  o  |   |  |   |",
                "+   +  +   +     +   +  +---+",
                "|   |  |   |  o  |   |  |   |",
                "|   |  |   |     |   |  |   |",
                "+---+  +---+     +---+  +---+",
                "",
                "",
        };

        String[] input = new String[] {
                "+---+  +---+     +---+  +---+",
                "|   |  |   |     |   |  |   |",
                "|   |  |   |  o  |   |  |   |",
                "+   +  +   +     +   +  +---+",
                "|   |  |   |  o  |   |  |   |",
                "|   |  |   |     |   |  |   |",
                "+---+  +---+     +---+  +---+",
                null,
                null,
        };

        String[] actual = digitalPrinter.printLinesAfterTime(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPrintEndString() {

        ArrayList<String[]> expected = new ArrayList<>();

        String[] time1647 = new String[] {
                "    +  +---+     +   +  +---+",
                "    |  |         |   |      |",
                "    |  |      o  |   |      |",
                "    +  +---+     +---+      +",
                "    |  |   |  o      |      |",
                "    |  |   |         |      |",
                "    +  +---+         +      +",
                "",
                ""
        };

        String[] time0008 = new String[] {
                "+---+  +---+     +---+  +---+",
                "|   |  |   |     |   |  |   |",
                "|   |  |   |  o  |   |  |   |",
                "+   +  +   +     +   +  +---+",
                "|   |  |   |  o  |   |  |   |",
                "|   |  |   |     |   |  |   |",
                "+---+  +---+     +---+  +---+",
                "",
                "",
        };

        String[] endLine = new String[] {"end"};
        expected.add(time1647);
        expected.add(time0008);
        expected.add(endLine);

        ArrayList<String[]> input = new ArrayList<>();
        input.add(time1647);
        input.add(time0008);

        ArrayList<String[]> actual = digitalPrinter.printEndString(input);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}