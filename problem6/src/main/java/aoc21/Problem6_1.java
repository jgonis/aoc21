package aoc21;

import java.io.InputStream;
import java.util.List;

public class Problem6_1 {

    public static final int DAY_LIMIT = 80;

    long solve(InputStream problemInput) {
        List<AOCFish> fishes = CommonMethods.getAocFish(problemInput);
        calcFishes(fishes, DAY_LIMIT);

        return fishes.size();
    }

    public void calcFishes(List<AOCFish> fishes, int dayLimit) {
        for(int i = 1; i < dayLimit; i++) {
            fishes.stream().forEach((AOCFish fish) -> fish.age());
            long newFishToCreate = fishes.stream().filter((AOCFish fish) -> fish.shouldReproduce()).count();
            for(int j = 0; j < newFishToCreate; j++) {
                fishes.add(new AOCFish());
            }
        }
    }
}
