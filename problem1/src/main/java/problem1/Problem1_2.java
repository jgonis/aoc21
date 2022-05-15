package problem1;

import aocutils.AOCUtilities;
import com.google.common.collect.EvictingQueue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Problem1_2 {
    int solve(InputStream problemInput) {
        List<Integer> inputDepths = AOCUtilities.readInputIntoLines(problemInput)
                                                .stream()
                                                .map(Integer::valueOf)
                                                .toList();
        List<Integer> windowedDepths = translateDepthsToWindows(inputDepths);
        return CommonMethods.numberOfIncreasingDepths(windowedDepths);
    }

    private List<Integer> translateDepthsToWindows(List<Integer> inputDepths) {
        List<Integer> windowedDepths = new ArrayList<>();
        EvictingQueue<Integer> depthWindow = EvictingQueue.create(3);
        for(Integer depth : inputDepths) {
            depthWindow.add(depth);
            if(depthWindow.remainingCapacity() == 0) {
               windowedDepths.add(depthWindow.stream().reduce(0, Integer::sum));
            }
        }
        return windowedDepths;
    }
}
