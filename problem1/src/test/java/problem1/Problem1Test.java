package problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem1Test {

    private InputStream problemInput;

    @BeforeEach
    void setUp() {
        problemInput = getClass().getResourceAsStream("/RealInput.txt");
    }

    @Test
    void problem1_1_Solve_RealInput() {
        assertEquals(1715, new Problem1().solveProblem1(problemInput));
    }

    @Test
    void problem1_2_Solve_RealInput() {
        assertEquals(1739, new Problem1().solveProblem2(problemInput));
    }
}