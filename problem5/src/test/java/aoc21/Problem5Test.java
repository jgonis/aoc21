package aoc21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class Problem5Test {

    private InputStream problemInput;

    @BeforeEach
    void setUp() {
        problemInput = getClass().getResourceAsStream("/RealInput.txt");
    }

    @Test
    void problem1_1_Solve_RealInput() {
        assertEquals(6267, new Problem5().solveProblem1(problemInput));
    }

    @Test
    void problem1_2_Solve_RealInput() {
        assertEquals(20196, new Problem5().solveProblem2(problemInput));
    }
}