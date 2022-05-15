package aoc21;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Problem6_2 {

    long solve(InputStream problemInput) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        BlockingQueue<Long> resultQueue = new LinkedBlockingQueue<>();
        List<Integer> fishes = CommonMethods.getAocFish(problemInput).stream().map(AOCFish::getDaysUntilReproduction).toList();
        int dayLimit = 256;
        FishTotalWorker ftw = new FishTotalWorker(resultQueue);

        new Thread(ftw).start();
        for (Integer fish : fishes) {
            executorService.execute(new FishCalculationWorker(fish, dayLimit, resultQueue));
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ftw.shouldStop = true;

        return ftw.getFishCount() + fishes.size();
    }
}
