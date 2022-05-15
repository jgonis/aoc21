package problem3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonMethods {

    static String findMostCommonBit(List<String> inputLines, int index) {
        Map<String, Integer> bitCount = CommonMethods.getBitCount(inputLines, index);
        int zeroCount = bitCount.getOrDefault("0", 0);
        int oneCount = bitCount.getOrDefault("1", 0);
        if (zeroCount > oneCount) {
            return "0";
        } else {
            return "1";
        }
    }

    static String findLeastCommonBit(List<String> inputLines, int index) {
        Map<String, Integer> bitCount = getBitCount(inputLines, index);
        int zeroCount = bitCount.getOrDefault("0", 0);
        int oneCount = bitCount.getOrDefault("1", 0);
        if (zeroCount > oneCount) {
            return "1";
        } else {
            return "0";
        }
    }

     static Map<String, Integer> getBitCount(List<String> inputLines, int index) {
        Map<String, Integer> bitCount = new HashMap<>();
        for (String line : inputLines) {
            String bitAtIndex = String.valueOf(line.charAt(index));
            bitCount.compute(bitAtIndex,
                             (String k, Integer v) -> {
                                 if (v == null) {
                                     return 0;
                                 } else {
                                     return v + 1;
                                 }
                             });
        }
        return bitCount;
    }
}
