import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DigitalDisplayTest {

    private InputStream originalIn = System.in;

    @BeforeEach
    public void setInputStream() {
        System.setIn(originalIn);
    }

    @Test
    public void testMain() {

        ByteArrayInputStream in = new ByteArrayInputStream("16:47\n23:59\n00:08\nend".getBytes());
        System.setIn(in);

        try {
            DigitalDisplay.main(null);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRun() {
        ParserStub parserStub = new ParserStub();
        DigitalPrinter digitalPrinter = new DigitalPrinter();
        DigitalDisplay digitalDisplay = new DigitalDisplay(parserStub, digitalPrinter);

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

        ArrayList<String[]> actual = digitalDisplay.run();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}