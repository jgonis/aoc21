package aoc21;

import java.awt.*;
import java.util.Map;

public class HorizontalAOCLine extends AOCLine {


    public HorizontalAOCLine(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public void markWorld(Map<Point, Integer> world) {
        int startingX = Math.min(_startPoint.x, _endPoint.x);
        int endX = Math.max(_startPoint.x, _endPoint.x);
        int constantY = _startPoint.y;
        for(int currentX = startingX; currentX <= endX; currentX++) {
            Point currentPoint = new Point(currentX, constantY);
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
