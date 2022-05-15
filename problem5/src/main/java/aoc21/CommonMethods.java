package aoc21;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CommonMethods {
    public static java.util.List<AOCLine> parseInputIntoAOCLines(java.util.List<String> inputLines, boolean allowHorizontal) {
        List<AOCLine> aocLines = new ArrayList<>();
        for(String line : inputLines) {
            String[] split = line.split("->");
            Point startPoint = createPoint(split[0]);
            Point endPoint = createPoint(split[1]);
            AOCLine aocLine = generateLine(startPoint, endPoint, allowHorizontal);
            if(aocLine != null) {
                aocLines.add(aocLine);
            }
        }

        return aocLines;
    }

    private static AOCLine generateLine(Point startPoint, Point endPoint, boolean allowHorizontal) {
        if(startPoint.x == endPoint.x) {
            return new VerticalAOCLine(startPoint, endPoint);
        } else if(startPoint.y == endPoint.y){
            return new HorizontalAOCLine(startPoint, endPoint);
        } else {
            if(!allowHorizontal) {
                return null;
            } else {
                return new DiagonalAOCLine(startPoint, endPoint);
            }
        }
    }

    private static Point createPoint(String pointString) {
        String[] pointInputs = pointString.split(",");
        return new Point(Integer.parseInt(pointInputs[0].trim()), Integer.parseInt(pointInputs[1].trim()));
    }
}
