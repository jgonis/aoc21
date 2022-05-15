package aoc21;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonMethods {
    public static List<AOCFish> getAocFish(InputStream problemInput) {
        List<String> strings = AOCUtilities.readInputIntoLines(problemInput);
        List<AOCFish> fishes = List.of(strings.get(0).split(","))
                                   .stream()
                                   .map(Integer::parseInt)
                                   .map((Integer startingValue) -> new AOCFish(startingValue))
                                   .collect(Collectors.toCollection(ArrayList::new));
        return fishes;
    }
}
