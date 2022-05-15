package aoc21;

public class AOCFish {
    private Integer daysUntilReproduction;

    public AOCFish(Integer startingValue) {
        daysUntilReproduction = startingValue;
    }

    public AOCFish() {
        daysUntilReproduction = 9;
    }

    public boolean shouldReproduce() {
        if (daysUntilReproduction == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer getDaysUntilReproduction() {
        return daysUntilReproduction;
    }

    public void age() {
        if(daysUntilReproduction == 0) {
            daysUntilReproduction = 6;
        } else {
            daysUntilReproduction = daysUntilReproduction - 1;
        }
    }
}
