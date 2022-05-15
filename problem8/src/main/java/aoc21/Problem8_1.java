package aoc21;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;

public class Problem8_1 {
    private int oneCount = 0;
    private int fourCount = 0;
    private int sevenCount = 0;
    private int eightCount = 0;

    int solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        List<String> outputValues = inputLines.stream()
                                              .map((String line) -> {
            String[] splitLine = line.split("\\|");
            return splitLine[1];
        }).toList();

        outputValues.stream().forEach((String outputLine) -> {
            List<String> trimmedValues = List.of(outputLine.split(" ")).stream().map(String::trim).toList();
            trimmedValues.stream().forEach((String outputValue) -> {
                switch(outputValue.length()) {
                    case 2:
                        oneCount++;
                        break;
                    case 3:
                        sevenCount++;
                        break;
                    case 4:
                        fourCount++;
                        break;
                    case 7:
                        eightCount++;
                        break;
                }
            });
        });
        return oneCount + fourCount + sevenCount + eightCount;
    }
}
