package aoc21;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem8_2 {
    int solve(InputStream problemInput) {
        Map<Set<Character>, Integer> valueMap = new HashMap<>();
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        List<String> signalValues = inputLines.stream()
                .map((String line) -> {
                    String[] splitLine = line.split("\\|");
                    return splitLine[0];
                }).toList();

        List<String> outputValues = inputLines.stream()
                                              .map((String line) -> {
                                                  String[] splitLine = line.split("\\|");
                                                  return splitLine[1];
                                              }).toList();
       return 0;
    }
}
