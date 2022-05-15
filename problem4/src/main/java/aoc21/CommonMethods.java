package aoc21;

import java.util.ArrayList;
import java.util.List;

public class CommonMethods {
    public static List<BingoBoard> parseBoards(List<String> inputLines) {
        List<BingoBoard> boards = new ArrayList<>();
        BingoBoard.Builder builder = null;// = new BingoBoard.Builder(5, 5);
        for(String line : inputLines) {
            if(line.isBlank()) {
                if(builder != null) {
                    boards.add(builder.createBingoBoard());
                }
                builder = new BingoBoard.Builder(5, 5);
            } else {
                List<String> boardRow = List.of(line.split(" ")).stream().filter(s -> s.isBlank() == false).toList();
                BingoBoard.Builder finalBuilder = builder;
                boardRow.stream().forEach(cellValue -> finalBuilder.withCell(Integer.parseInt(cellValue)));
            }
        }
        boards.add(builder.createBingoBoard());
        return boards;
    }

}
