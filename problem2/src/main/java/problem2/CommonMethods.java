package problem2;

import java.util.Arrays;
import java.util.List;

public class CommonMethods {
    public static void parseSubCommands(List<String> inputLines, SubHeadingSolver solver) {
        inputLines.forEach((String line) -> {
                        List<String> splitInput = Arrays.stream(line.split(" "))
                                                        .filter((String input) -> !input.isBlank())
                                                        .toList();
                        int travel = Integer.parseInt(splitInput.get(1));
                        switch (splitInput.get(0)) {
                            case "down":
                                solver.down(travel);
                                break;
                            case "up":
                                solver.up(travel);
                                break;
                            case "forward":
                                solver.forward(travel);
                                break;
                            default: throw new IllegalArgumentException("Could not recognize direction to travel");
                        }
                    });
    }
}
