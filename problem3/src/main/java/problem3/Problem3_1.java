package problem3;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;

public class Problem3_1 {
    private final StringBuilder gammaRateString = new StringBuilder();
    private final StringBuilder epsilonRateString = new StringBuilder();

    long solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        for (int i = 0; i < inputLines.get(0).length(); i++) {
            gammaRateString.append(CommonMethods.findMostCommonBit(inputLines, i));
            epsilonRateString.append(CommonMethods.findLeastCommonBit(inputLines, i));
        }
        long gammaRate = Long.parseLong(gammaRateString.toString(), 2);
        long epsilonRate = Long.parseLong(epsilonRateString.toString(), 2);
        return gammaRate * epsilonRate;
    }
}
