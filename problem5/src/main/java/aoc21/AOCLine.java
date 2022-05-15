package aoc21;

import java.awt.*;
import java.util.Map;

public abstract class AOCLine {
    protected final Point _startPoint;
    protected final Point _endPoint;

    public AOCLine(Point _startPoint, Point _endPoint) {
        this._startPoint = _startPoint;
        this._endPoint = _endPoint;
    }

    abstract void markWorld(Map<Point, Integer> world);
}
