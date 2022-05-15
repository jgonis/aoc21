/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aoc21;

import java.io.InputStream;

public class Problem10 {

    public static void main(String[] args) {
        Problem10 problem10 = new Problem10();
        problem10.solveProblem1();
        problem10.solveProblem2();
    }

    private void solveProblem1() {
        InputStream problemInput = getClass().getResourceAsStream("/RealInput.txt");
        System.out.println(solveProblem1(problemInput));
    }

    private void solveProblem2() {
        InputStream problemInput = getClass().getResourceAsStream("/RealInput.txt");
        System.out.println(solveProblem1(problemInput));
    }

    int solveProblem1(InputStream problemInput) {
        return new Problem10_1().solve(problemInput);
    }

    int solveProblem2(InputStream problemInput) {
        return new Problem10_2().solve(problemInput);
    }
}