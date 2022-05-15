package aoc21;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class FishTotalWorker implements Runnable{
    private final BlockingQueue<Long> resultQueue;
    public boolean shouldStop = false;

    public long getFishCount() {
        return _fishCount;
    }

    private long _fishCount = 0L;

    public FishTotalWorker(BlockingQueue<Long> resultQueue) {
        this.resultQueue = resultQueue;
    }

    @Override
    public void run() {
        while(!shouldStop) {
            try {
                Long fishCount = resultQueue.poll(1, TimeUnit.SECONDS);
                if(fishCount != null) {
                    _fishCount = _fishCount + fishCount;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
