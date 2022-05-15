package problem2;

import aocutils.AOCUtilities;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

public class Problem2_1 implements SubHeadingSolver {
    private final Point subPosition = new Point(0, 0);
    int solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        CommonMethods.parseSubCommands(inputLines, this);
        return getResult();
    }

    @Override
    public void down(int travel) {
        subPosition.translate(0, travel);
    }

    @Override
    public void up(int travel) {
        subPosition.translate(0, -1 * travel);
    }

    @Override
    public void forward(int travel) {
        subPosition.translate(travel, 0);
    }

    @Override
    public int getResult() {
        return subPosition.x * subPosition.y;
    }
}
