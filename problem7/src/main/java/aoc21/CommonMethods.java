package aoc21;

import aocutils.AOCUtilities;

import java.io.InputStream;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class CommonMethods {
    private int currentPoint;
    private int currentState;
    private int distance;
    private final BiFunction<Integer, Integer, Integer> distanceFunction;

    public CommonMethods(BiFunction<Integer, Integer, Integer> distanceFunction) {
        this.distanceFunction = distanceFunction;
    }

    public int totalDistance(int point, List<Integer> otherPoints) {
        Integer totalDistance = otherPoints.stream()
                                           .map(a -> distanceFunction.apply(point, a))//absDistance(point, a))//Math.abs(point - a))
                                           .reduce(0, Integer::sum);
        return totalDistance;
    }

    int absDistance(int a, int b) {
        return Math.abs(a - b);
    }

    int solve(InputStream problemInput) {
        List<String> input = AOCUtilities.readInputIntoLines(problemInput);
        List<Integer> points = Stream.of(input.get(0).split(",")).map(Integer::parseInt).toList();

        //initialize state to average of all points
        currentPoint = Math.round(points.stream().reduce(0, Integer::sum) / (points.size() * 1.0f));
        currentState = totalDistance(currentPoint,  points);
        int max = points.stream().max(Integer::compare).get();
        int min = points.stream().min(Integer::compare).get();
        distance = Math.round(Math.round((max - min) / 2.0f));
        while(distance >= 1) {
            //calculate candidate left and right
            int newStateLeft = totalDistance(currentPoint - distance, points);
            int newStateRight = totalDistance(currentPoint + distance, points);
            //if left or right are better choose best
            if(newStateRight <= newStateLeft) {
                calculateNewSearchParameters(newStateRight, points, Integer::sum);
            } else {
                calculateNewSearchParameters(newStateLeft, points, (a, b) -> (a - b));
            }
        }
        return currentState;
    }
    public void calculateNewSearchParameters(int stateToCompareAgainst, List<Integer> points, BiFunction<Integer, Integer, Integer> newPointCalculationFunc) {
        if (stateToCompareAgainst < currentState) {
            currentPoint = newPointCalculationFunc.apply(currentPoint, distance);
            currentState = totalDistance(currentPoint, points);
        } else {
            distance = reduceSearchDistance(distance);
        }
    }

    private int reduceSearchDistance(int distance) {
        float halfDistance = distance / 2.0f;
        if(halfDistance < 1.0) {
            distance = 0;
        } else {
            distance = Math.round(halfDistance);
        }
        return distance;
    }
}
