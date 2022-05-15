package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem2Test {

    private InputStream problemInput;

    @BeforeEach
    void setUp() {
        problemInput = getClass().getResourceAsStream("/RealInput.txt");
    }

    @Test
    void problem1_1_Solve_RealInput() {
        assertEquals(2322630, new Problem2().solveProblem1(problemInput));
    }

    @Test
    void problem1_2_Solve_RealInput() {
        assertEquals(2105273490, new Problem2().solveProblem2(problemInput));
    }
}