package aoc21;

import aocutils.AOCUtilities;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Problem5_2 {
    long solve(InputStream problemInput) {
        Map<Point, Integer> world = new HashMap<>();
        java.util.List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        java.util.List<AOCLine> lines = CommonMethods.parseInputIntoAOCLines(inputLines, true);
        for(AOCLine line : lines) {
            line.markWorld(world);
        }

        return world.values().stream().filter(value -> value >= 2).count();
    }
}
