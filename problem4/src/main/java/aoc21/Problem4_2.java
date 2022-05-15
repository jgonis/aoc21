package aoc21;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;

public class Problem4_2 {
    long solve(InputStream problemInput) {
        List<String> inputLines = AOCUtilities.readInputIntoLines(problemInput);
        List<Integer> numbersToDraw = List.of(inputLines.remove(0).split(",")).stream().map(Integer::parseInt).toList();
        List<BingoBoard> boards = CommonMethods.parseBoards(inputLines);
        BingoBoard lastBoard = null;
        for(Integer drawnNumber : numbersToDraw) {
            for(BingoBoard board : boards) {
                board.numberDrawn(drawnNumber);
                if(!board.hasWon() && board.isWinner()) {
                    List<BingoBoard> bingoBoards = boards.stream().filter(bingoBoard -> !bingoBoard.hasWon()).toList();
                    if(bingoBoards.size() == 1) {
                        lastBoard = boards.get(boards.indexOf(bingoBoards.get(0)));
                    } else if (bingoBoards.size() == 0) {
                        return lastBoard.getUnmarkedSum() * drawnNumber;
                    }

                }
            }
        }
        return 0;
    }
}
