/**
 *  Inspired from the Kattis Problem: Digital Display
 *  https://open.kattis.com/problems/display
 */

import java.util.*;


interface UnitTest {
    String[] testPrintTime(String time);
}

interface IntegrationTest {
    ArrayList<String[]> testRun(ArrayList<String> times);
}


public class DigitalDisplay implements UnitTest, IntegrationTest {

    private HashMap<String, String[]> hMap;

    public DigitalDisplay() {
        this.hMap = setHashMap();
    }

    public static void main(String[] args) {
        DigitalDisplay digitalDisplay = new DigitalDisplay();
        ArrayList<String> times = digitalDisplay.readTimes();
        digitalDisplay.run(times);
    }

    private ArrayList<String[]> run(ArrayList<String> times) {

        ArrayList<String[]> digitalTimes = new ArrayList<>();

        for (String time: times) {
            String[] digitalTime = printTime(time);
            digitalTimes.add(digitalTime);
        }

        String endString = "end";
        digitalTimes.add(new String[]{endString});
        System.out.println(endString);

        return digitalTimes;
    }

    private String[] printTime(String time) {
        String[] digitalTime = new String[9];

        int line = 0;

        while (line < 7) {
            String digitalLine = "";
            for (int i = 0; i < time.length(); i++) {

                String l = hMap.get(Character.toString(time.charAt(i)))[line];
                System.out.print(l);
                digitalLine += l;

                if (i != time.length() - 1) {
                    String s = hMap.get(Character.toString(' '))[line];
                    System.out.print(s);
                    digitalLine += s;
                }
            }
            digitalTime[line++] = digitalLine;
            System.out.println();
        }

        for (int i = 0; i < 2; i++) {
            digitalTime[line++] = "";
            System.out.println();
        }

        return digitalTime;
    }

    private ArrayList<String> readTimes() {
        ArrayList<String> inputs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            inputs.add(input);
        }
        return inputs;
    }

    private HashMap<String, String[]> setHashMap() {
        HashMap<String, String[]> hMap = new HashMap<>();

        hMap.put("0", new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+   +",
                "|   |",
                "|   |",
                "+---+"});

        hMap.put("1", new String[]{
                "    +",
                "    |",
                "    |",
                "    +",
                "    |",
                "    |",
                "    +"});

        hMap.put("2", new String[]{
                "+---+",
                "    |",
                "    |",
                "+---+",
                "|    ",
                "|    ",
                "+---+"});

        hMap.put("3", new String[]{
                "+---+",
                "    |",
                "    |",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        hMap.put("4", new String[]{
                "+   +",
                "|   |",
                "|   |",
                "+---+",
                "    |",
                "    |",
                "    +"});

        hMap.put("5", new String[]{
                "+---+",
                "|    ",
                "|    ",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        hMap.put("6", new String[]{
                "+---+",
                "|    ",
                "|    ",
                "+---+",
                "|   |",
                "|   |",
                "+---+"});

        hMap.put("7", new String[]{
                "+---+",
                "    |",
                "    |",
                "    +",
                "    |",
                "    |",
                "    +"});

        hMap.put("8", new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+---+",
                "|   |",
                "|   |",
                "+---+"});

        hMap.put("9", new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        hMap.put(":", new String[]{
                " ",
                " ",
                "o",
                " ",
                "o",
                " ",
                " "});

        hMap.put(" ", new String[]{
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "});

        return hMap;
    }

    @Override
    public String[] testPrintTime(String time) {
        return printTime(time);
    }

    @Override
    public ArrayList<String[]> testRun(ArrayList<String> times) {
        return run(times);
    }
}