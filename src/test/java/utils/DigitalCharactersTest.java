package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DigitalCharactersTest {

    private DigitalCharacters digitalCharacters;

    @BeforeEach
    public void initialise() {
        digitalCharacters = new DigitalCharacters();
    }

    @Test
    public void testGetCharacterMap() {

        HashMap<Character, String[]> expected = new HashMap<>();

        expected.put('0', new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+   +",
                "|   |",
                "|   |",
                "+---+"});

        expected.put('1', new String[]{
                "    +",
                "    |",
                "    |",
                "    +",
                "    |",
                "    |",
                "    +"});

        expected.put('2', new String[]{
                "+---+",
                "    |",
                "    |",
                "+---+",
                "|    ",
                "|    ",
                "+---+"});

        expected.put('3', new String[]{
                "+---+",
                "    |",
                "    |",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        expected.put('4', new String[]{
                "+   +",
                "|   |",
                "|   |",
                "+---+",
                "    |",
                "    |",
                "    +"});

        expected.put('5', new String[]{
                "+---+",
                "|    ",
                "|    ",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        expected.put('6', new String[]{
                "+---+",
                "|    ",
                "|    ",
                "+---+",
                "|   |",
                "|   |",
                "+---+"});

        expected.put('7', new String[]{
                "+---+",
                "    |",
                "    |",
                "    +",
                "    |",
                "    |",
                "    +"});

        expected.put('8', new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+---+",
                "|   |",
                "|   |",
                "+---+"});

        expected.put('9', new String[]{
                "+---+",
                "|   |",
                "|   |",
                "+---+",
                "    |",
                "    |",
                "+---+"});

        expected.put(':', new String[]{
                " ",
                " ",
                "o",
                " ",
                "o",
                " ",
                " "});

        expected.put(' ', new String[]{
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "});

        HashMap<Character, String[]> actual = digitalCharacters.getCharacterMap();

        assertTrue(areEqual(expected, actual));
    }

    private boolean areEqual(Map<Character, String[]> first, Map<Character, String[]> second) {
        if (first.size() != second.size()) {
            return false;
        }
        return first.entrySet().stream().allMatch(e -> Arrays.equals(e.getValue(), second.get(e.getKey())));
    }

}