package aocutils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class AOCUtilities {
    public static List<String> readInputIntoLines(InputStream problemInput) {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(problemInput));

        return inputReader.lines()
                          .collect(Collectors.toList());
    }
}
