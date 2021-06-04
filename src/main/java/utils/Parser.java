package utils;

import java.io.InputStream;
import java.util.*;

public class Parser {

    public ArrayList<String> read(InputStream in) {

        Scanner scanner = new Scanner(in);
        ArrayList<String> inputs = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            inputs.add(input);
        }

        return inputs;
    }

}
