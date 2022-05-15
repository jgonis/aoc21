package aoc21;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {

    private InputStream problemInput;

    @BeforeEach
    void setUp() {
        problemInput = getClass().getResourceAsStream("/Input.txt");
    }

    @Test
    void problem1_1_Solve_RealInput() {
        assertEquals(5934, new Problem6().solveProblem1(problemInput));
    }

    @Test
    void problem1_2_Solve_RealInput() {
        assertEquals(26984457539L, new Problem6().solveProblem2(problemInput));
        //assertEquals(5934L, new Problem6().solveProblem2(problemInput));
    }
}