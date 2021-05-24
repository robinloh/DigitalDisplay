import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DigitalDisplayTest {

    @Test
    public void testPrintTime1647() {
        String[] expectedTime = new String[] {
                "    +  +---+     +   +  +---+",
                "    |  |         |   |      |",
                "    |  |      o  |   |      |",
                "    +  +---+     +---+      +",
                "    |  |   |  o      |      |",
                "    |  |   |         |      |",
                "    +  +---+         +      +",
                "",
                "",
        };
        DigitalDisplay testDigitalDisplay = new DigitalDisplay();
        Assert.assertArrayEquals(expectedTime, testDigitalDisplay.testPrintTime("16:47"));
    }

    @Test
    public void testPrintTime2359() {
        String[] expectedTime = new String[] {
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
        DigitalDisplay testDigitalDisplay = new DigitalDisplay();
        Assert.assertArrayEquals(expectedTime, testDigitalDisplay.testPrintTime("23:59"));
    }

    @Test
    public void testPrintTime0008() {
        String[] expectedTime = new String[] {
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
        DigitalDisplay testDigitalDisplay = new DigitalDisplay();
        Assert.assertArrayEquals(expectedTime, testDigitalDisplay.testPrintTime("00:08"));
    }

    /**************     Integration Tests   ******************/

    @Test
    public void testRun() {

        String[] expectedTime1647 = new String[] {
                "    +  +---+     +   +  +---+",
                "    |  |         |   |      |",
                "    |  |      o  |   |      |",
                "    +  +---+     +---+      +",
                "    |  |   |  o      |      |",
                "    |  |   |         |      |",
                "    +  +---+         +      +",
                "",
                "",
        };

        String[] expectedTime2359 = new String[] {
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

        String[] expectedTime0008 = new String[] {
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

        String[] expectedEnd = new String[]{"end"};

        ArrayList<String[]> expectedTime = new ArrayList<>();
        expectedTime.add(expectedTime1647);
        expectedTime.add(expectedTime2359);
        expectedTime.add(expectedTime0008);
        expectedTime.add(expectedEnd);

        ArrayList<String> actualTimeInputs = new ArrayList<>();
        actualTimeInputs.add("16:47");
        actualTimeInputs.add("23:59");
        actualTimeInputs.add("00:08");

        DigitalDisplay testDigitalDisplay = new DigitalDisplay();
        Assert.assertArrayEquals(expectedTime.toArray(), testDigitalDisplay.testRun(actualTimeInputs).toArray());
    }

}
