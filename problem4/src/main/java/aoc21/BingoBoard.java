package aoc21;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BingoBoard {
    private final List<List<BingoBoardCell>> _cells;
    private boolean hasWon = false;

    private BingoBoard(List<List<BingoBoardCell>> cells) {
        _cells = cells;
    }

    public void numberDrawn(Integer drawnNumber) {
        for (List<BingoBoardCell> boardRow : _cells) {
            boardRow.stream()
                    .filter(cell -> cell.getValue().equals(drawnNumber))
                    .findFirst()
                    .ifPresent(BingoBoardCell::setMarked);
        }
    }

    public boolean isWinner() {
        boolean anyHorizontalRowsFilledIn = _cells.stream()
                                                  .anyMatch((List<BingoBoardCell> cellRow) -> cellRow.stream().allMatch(BingoBoardCell::isMarked));
        boolean verticalMatch = false;
        for (int x = 0; x < _cells.get(0).size(); x++) {
            boolean allMarked = true;
            for (List<BingoBoardCell> cell : _cells) {
                if (!cell.get(x).isMarked()) {
                    allMarked = false;
                    break;
                }
            }
            if (allMarked) {
                verticalMatch = true;
                break;
            }
        }
        if (anyHorizontalRowsFilledIn || verticalMatch)
            hasWon = true;

        return hasWon;
    }

    public long getUnmarkedSum() {
        List<Integer> rowSums = _cells.stream().map((List<BingoBoardCell> cellRow) -> cellRow.stream()
                                                                                             .filter(cell -> !cell.isMarked())
                                                                                             .map(BingoBoardCell::getValue)
                                                                                             .reduce(0, Integer::sum)).toList();
        return rowSums.stream().reduce(0, Integer::sum);
    }

    public boolean hasWon() {
        return hasWon;
    }


    private static class BingoBoardCell {
        private final Integer _value;
        private boolean _isMarked = false;

        public BingoBoardCell(Integer value) {
            this._value = value;
        }

        public boolean isMarked() {
            return _isMarked;
        }

        public void setMarked() {
            _isMarked = true;
        }

        public Integer getValue() {
            return _value;
        }
    }

    public static class Builder {
        private final List<List<BingoBoardCell>> _cells = new ArrayList<>();
        private Point _pos = new Point(0, 0);

        public Builder(int boardWidth, int boardHeight) {
            for (int i = 0; i < boardHeight; i++) {
                List<BingoBoardCell> cellRow = new ArrayList<>(boardWidth);
                _cells.add(cellRow);
            }
        }

        public BingoBoard createBingoBoard() {
            return new BingoBoard(_cells);
        }

        public Builder withCell(Integer value) {
            _cells.get(_pos.y).add(_pos.x, new BingoBoardCell(value));
            _pos.x = _pos.x + 1;
            if (_pos.x >= 5) {
                _pos.x = 0;
                _pos.y = _pos.y + 1;
            }
            return this;
        }

    }

}
