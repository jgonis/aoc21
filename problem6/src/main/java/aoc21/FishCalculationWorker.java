package aoc21;

import java.util.concurrent.BlockingQueue;

public class FishCalculationWorker implements Runnable {
    private final int _currentFishAge;
    private final BlockingQueue<Long> _resultQueue;
    private long fishCount = 0L;
    private final int _dayLimit;

    public FishCalculationWorker(int currentFishAge, int dayLimit, BlockingQueue<Long> resultQueue) {
        _currentFishAge = currentFishAge;
        _dayLimit = dayLimit;
        _resultQueue = resultQueue;
    }

    @Override
    public void run() {
        calcFish(0, _currentFishAge);
        try {
            _resultQueue.put(fishCount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void calcFish(int currentDay, int currentFishAge) {
        if(currentDay != _dayLimit) {
            if(currentFishAge == 0) {
                fishCount++;
                calcFish(currentDay + 1, 8);
                calcFish(currentDay + 1, 6);
            } else {
                calcFish(currentDay + 1, currentFishAge - 1);
            }
        }
    }
}
