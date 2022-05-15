package problem1;

import com.google.common.collect.EvictingQueue;

import java.util.List;

public class CommonMethods {

    public static int numberOfIncreasingDepths(List<Integer> inputDepths) {
        EvictingQueue<Integer> window = EvictingQueue.create(2);
        int greaterThan = 0;
        for(Integer depth : inputDepths) {
            window.add(depth);
            if(window.remainingCapacity() == 0) {
                List<Integer> depthWindow = window.stream().toList();
                if(depthWindow.get(1) > depthWindow.get(0))
                    greaterThan++;
            }
        }
        return  greaterThan;
    }
}
