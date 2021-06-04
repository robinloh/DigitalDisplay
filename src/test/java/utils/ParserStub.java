package utils;

import java.io.InputStream;
import java.util.ArrayList;

public class ParserStub extends Parser {

    @Override
    public ArrayList<String> read(InputStream in) {
        ArrayList<String> times = new ArrayList<>();
        times.add("16:47");
        times.add("23:59");
        times.add("00:08");
        return times;
    }
}
