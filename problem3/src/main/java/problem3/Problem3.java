/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package problem3;

import java.io.InputStream;

public class Problem3 {

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        problem3.solveProblem1();
        problem3.solveProblem2();
    }

    private void solveProblem1() {
        InputStream problemInput = getClass().getResourceAsStream("/RealInput.txt");
        System.out.println("Problem 3_1 solution: " + solveProblem1(problemInput));
    }

    private void solveProblem2() {
        InputStream problemInput = getClass().getResourceAsStream("/RealInput.txt");
        System.out.println("Problem 3_2 solution: " + solveProblem2(problemInput));
    }

    long solveProblem1(InputStream problemInput) {
        return new Problem3_1().solve(problemInput);
    }

    long solveProblem2(InputStream problemInput) {
        return new Problem3_2().solve(problemInput);
    }
}
