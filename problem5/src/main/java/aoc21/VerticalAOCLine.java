package aoc21;

import java.awt.*;
import java.util.Map;

public class VerticalAOCLine extends AOCLine {
    public VerticalAOCLine(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public void markWorld(Map<Point, Integer> world) {
        int startingY = Math.min(_startPoint.y, _endPoint.y);
        int endY = Math.max(_startPoint.y, _endPoint.y);
        int constantX = _startPoint.x;
        for(int currentY = startingY; currentY <= endY; currentY++) {
            Point currentPoint = new Point(constantX, currentY);
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
