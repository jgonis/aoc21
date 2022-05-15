package aoc21;

import java.io.InputStream;
import java.util.function.BiFunction;

public class Problem7_1 {


    public int solve(InputStream problemInput) {
        BiFunction<Integer, Integer, Integer> absDistance = (Integer testPoint, Integer otherPoint) -> Math.abs(testPoint - otherPoint);
        return new CommonMethods(absDistance).solve(problemInput);
    }


}
