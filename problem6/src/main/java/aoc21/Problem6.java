/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc21;

import java.io.InputStream;

public class Problem6 {

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        problem6.solveProblem1();
        problem6.solveProblem2();
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
        return new Problem6_1().solve(problemInput);
    }

    long solveProblem2(InputStream problemInput) {
        return new Problem6_2().solve(problemInput);
    }
}