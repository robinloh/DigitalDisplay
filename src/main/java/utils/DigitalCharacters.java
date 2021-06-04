package utils;

import java.util.HashMap;

public class DigitalCharacters {

    private final HashMap<Character, String[]> characterMap;

    public DigitalCharacters() {
        this.characterMap = setMap();
    }

    public HashMap<Character, String[]> getCharacterMap() {
        return characterMap;
    }

    private static HashMap<Character, String[]> setMap() {

        HashMap<Character, String[]> hMap = new HashMap<>();

        hMap.put('0', new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+   +",
                "|   |",
                "|   |",
                "+---+"});

        hMap.put('1', new String[]{
                "    +",
                "    |",
                "    |",
                "    +",
                "    |",
                "    |",
                "    +"});

        hMap.put('2', new String[]{
                "+---+",
                "    |",
                "    |",
                "+---+",
                "|    ",
                "|    ",
                "+---+"});

        hMap.put('3', new String[]{
                "+---+",
                "    |",
                "    |",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        hMap.put('4', new String[]{
                "+   +",
                "|   |",
                "|   |",
                "+---+",
                "    |",
                "    |",
                "    +"});

        hMap.put('5', new String[]{
                "+---+",
                "|    ",
                "|    ",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        hMap.put('6', new String[]{
                "+---+",
                "|    ",
                "|    ",
                "+---+",
                "|   |",
                "|   |",
                "+---+"});

        hMap.put('7', new String[]{
                "+---+",
                "    |",
                "    |",
                "    +",
                "    |",
                "    |",
                "    +"});

        hMap.put('8', new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+---+",
                "|   |",
                "|   |",
                "+---+"});

        hMap.put('9', new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        hMap.put(':', new String[]{
                " ",
                " ",
                "o",
                " ",
                "o",
                " ",
                " "});

        hMap.put(' ', new String[]{
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "});

        return hMap;
    }

}
