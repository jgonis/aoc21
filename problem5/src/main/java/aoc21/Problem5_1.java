package aoc21;

import aocutils.AOCUtilities;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem5_1 {

    long solve(InputStream problemInput) {
        Map<Point, Integer> world = new HashMap<>();
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        List<AOCLine> lines = CommonMethods.parseInputIntoAOCLines(inputLines, false);
        for(AOCLine line : lines) {
            line.markWorld(world);
        }

        return world.values().stream().filter(value -> value >= 2).count();
    }
}
