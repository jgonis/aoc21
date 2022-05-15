package problem2;

import aocutils.AOCUtilities;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

public class Problem2_2 implements SubHeadingSolver {
    private final Point subPosition = new Point(0, 0);
    private int aim = 0;

    int solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        CommonMethods.parseSubCommands(inputLines, this);
        return getResult();
    }

    @Override
    public void down(int travel) {
        aim += travel;
    }

    @Override
    public void up(int travel) {
        aim -= travel;
    }

    @Override
    public void forward(int travel) {
        subPosition.translate(travel, aim * travel);
    }

    @Override
    public int getResult() {
        return subPosition.x * subPosition.y;
    }
}
