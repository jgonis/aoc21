/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc21;

import java.io.InputStream;

public class Problem4 {

    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        problem4.solveProblem1();
        problem4.solveProblem2();
    }

    private void solveProblem1() {
        InputStream problemInput = getClass().getResourceAsStream("/RealInput.txt");
        System.out.println(solveProblem1(problemInput));
    }

    private void solveProblem2() {
        InputStream problemInput = getClass().getResourceAsStream("/RealInput.txt");
        System.out.println(solveProblem2(problemInput));
    }

    long solveProblem1(InputStream problemInput) {
        return new Problem4_1().solve(problemInput);
    }

    long solveProblem2(InputStream problemInput) {
        return new Problem4_2().solve(problemInput);
    }
}
