package problem1;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;

public class Problem1_1 {
    int solve(InputStream problemInput) {
        List<Integer> inputDepths = AOCUtilities.readInputIntoLines(problemInput)
                                                .stream()
                                                .map(Integer::valueOf)
                                                .toList();
        return CommonMethods.numberOfIncreasingDepths(inputDepths);
    }
}
