package problem3;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;
import java.util.function.BiFunction;

public class Problem3_2 {
    long solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);

        long oxygenGeneratorRating = getOxygenGeneratorRating(inputLines);
        long co2ScrubberRating = getCO2ScrubberRating(inputLines);

        return oxygenGeneratorRating * co2ScrubberRating;

    }

    private long getCO2ScrubberRating(List<String> inputLines) {
        BiFunction<List<String>, Integer, String> findBit = CommonMethods::findLeastCommonBit;
        return parseInput(inputLines, findBit);
    }

    private long getOxygenGeneratorRating(List<String> inputLines) {
        BiFunction<List<String>, Integer, String> findBit = CommonMethods::findMostCommonBit;
        return parseInput(inputLines, findBit);
    }

    private long parseInput(List<String> inputLines,BiFunction<List<String>, Integer, String> findBit) {
        boolean continueFiltering = true;
        int index = 0;
        while (continueFiltering) {
            String foundBit = findBit.apply(inputLines, index);
            int finalIndex = index;
            inputLines = inputLines.stream()
                                   .filter((String line) -> foundBit.equals(String.valueOf(line.charAt(finalIndex))))
                                   .toList();
            if (inputLines.size() == 1) {
                continueFiltering = false;
            }
            index++;
        }

        return Long.parseLong(inputLines.get(0), 2);
    }
}
