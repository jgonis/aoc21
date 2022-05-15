package aoc21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    private InputStream problemInput;

    @BeforeEach
    void setUp() {
        problemInput = getClass().getResourceAsStream("/Input.txt");
    }

    @Test
    void problem1_1_Solve_RealInput() {
        assertEquals(26, new Problem8().solveProblem1(problemInput));
    }

    @Test
    void problem1_2_Solve_RealInput() {
        assertEquals(0, new Problem8().solveProblem2(problemInput));
    }
}