package utils;

import java.util.ArrayList;

public class DigitalPrinterStub extends DigitalPrinter {

    public ArrayList<String[]> printDigitalDisplay() {

        ArrayList<String[]> digitalTimes = new ArrayList<>();

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
        digitalTimes.add(time1647);
        digitalTimes.add(time2359);
        digitalTimes.add(time0008);
        digitalTimes.add(endLine);

        return digitalTimes;
    }
}
