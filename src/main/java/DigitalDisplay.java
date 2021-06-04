/**
 *  Inspired from the Kattis Problem: Digital Display
 *  https://open.kattis.com/problems/display
 */

import utils.Printer;
import utils.Parser;
import utils.DigitalPrinter;

import java.util.*;


public class DigitalDisplay {

    private final Parser parser;
    private final Printer printer;

    public DigitalDisplay(Parser parser, Printer printer) {
        this.parser = parser;
        this.printer = printer;
    }

    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new DigitalPrinter();

        DigitalDisplay digitalDisplay = new DigitalDisplay(parser, printer);
        digitalDisplay.run();
    }

    public ArrayList<String[]> run() {
        ArrayList<String> times = parser.read(System.in);
        ArrayList<String[]> digitalTimes = printer.printDigitalDisplay(times);
        return digitalTimes;
    }

}