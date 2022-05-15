package aoc21;

import java.awt.*;
import java.util.Map;

public class DiagonalAOCLine extends AOCLine {
    public DiagonalAOCLine(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    void markWorld(Map<Point, Integer> world) {
        int xOffset;
        if(_startPoint.x < _endPoint.x) {
            xOffset = 1;
        } else {
            xOffset = -1;
        }

        int yOffset;
        if(_startPoint.y < _endPoint.y) {
            yOffset = 1;
        } else {
            yOffset = -1;
        }
        for(int count = 0; count <= Math.abs(_startPoint.x - _endPoint.x); count++) {
            Point currentPoint = new Point(_startPoint.x + (count * xOffset), _startPoint.y + (count * yOffset));
            world.compute(currentPoint, (k, v) -> {
                if(v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }
    }
}
