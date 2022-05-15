package aoc21;

import java.io.InputStream;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Problem7_2 {
    int solve(InputStream problemInput) {
        BiFunction<Integer, Integer, Integer> sumDistance = (Integer testPoint, Integer otherPoint) -> {
            int absDistance = Math.abs(testPoint - otherPoint);
            return IntStream.range(0, absDistance+1).reduce(0, Integer::sum);
        };
        return new CommonMethods(sumDistance).solve(problemInput);
    }
}
