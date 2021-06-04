package utils;

import java.util.*;

public class DigitalPrinter implements Printer {

    public static final int CHARACTER_WIDTH = 7;
    public static final int LINE_SPACING = 2;
    public static final char SPACE = ' ';

    private final DigitalCharacters digitalCharacters;
    private final TimeValidator timeValidator;

    public DigitalPrinter() {
        this.digitalCharacters = new DigitalCharacters();
        this.timeValidator = new TimeValidator();
    }

    public DigitalPrinter(DigitalCharacters digitalCharacters, TimeValidator timeValidator) {
        this.digitalCharacters = digitalCharacters;
        this.timeValidator = timeValidator;
    }

    public ArrayList<String[]> printDigitalDisplay(ArrayList<String> times) {
        ArrayList<String[]> digitalTimes = new ArrayList<>();

        for (String time: times) {
            if (timeValidator.validate(time)) {
                String[] digitalTime = printTime(time);
                printLinesAfterTime(digitalTime);
                digitalTimes.add(digitalTime);
            }
        }

        printEndString(digitalTimes);
        return digitalTimes;
    }

    public String[] printTime(String time) {

        String[] digitalTime = new String[CHARACTER_WIDTH + LINE_SPACING];

        for (int line = 0; line < CHARACTER_WIDTH; line++) {
            String digitalLine = "";
            for (int i = 0; i < time.length(); i++) {
                digitalLine += printCharByLine(time.charAt(i), line);
                if (i < time.length() - 1) {
                    digitalLine += printCharByLine(SPACE, line);
                } else {
                    digitalTime[line] = digitalLine;
                    System.out.println();
                }
            }
        }

        return digitalTime;
    }

    public String printCharByLine(char ch, int line) {
        HashMap<Character, String[]> characterMap = digitalCharacters.getCharacterMap();
        String charByLine = characterMap.get(ch)[line];
        System.out.print(charByLine);
        return charByLine;
    }

    public String[] printLinesAfterTime(String[] digitalTime) {
        for (int i = 0; i < LINE_SPACING; i++) {
            digitalTime[CHARACTER_WIDTH + i] = "";
            System.out.println();
        }
        return digitalTime;
    }

    public ArrayList<String[]> printEndString(ArrayList<String[]> digitalTimes) {
        String endString = "end";
        digitalTimes.add(new String[]{endString});
        System.out.println(endString);
        return digitalTimes;
    }

}
