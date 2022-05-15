package aoc21;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;

public class Problem4_1 {
    long solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        List<Integer> numbersToDraw = List.of(inputLines.remove(0).split(",")).stream().map(Integer::parseInt).toList();
        List<BingoBoard> boards = CommonMethods.parseBoards(inputLines);
        for(Integer drawnNumber : numbersToDraw) {
            for(BingoBoard board : boards) {
                board.numberDrawn(drawnNumber);
                if(board.isWinner()) {
                    return board.getUnmarkedSum() * drawnNumber;
                }
            }
        }
        return 0;
    }
}
