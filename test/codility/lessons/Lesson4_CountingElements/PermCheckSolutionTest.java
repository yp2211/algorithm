package codility.lessons.Lesson4_CountingElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class PermCheckSolutionTest {
    @Test
    void solutionExample1() {
        int[] A = new int[] {4, 1, 3, 2};
        int expected = 1;
        int actual = (new PermCheckSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionExample2() {
        int[] A = new int[] {4, 1, 3};
        int expected = 0;
        int actual = (new PermCheckSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionSingle() {
        int[] A = new int[] { 1 };
        int expected = 1;
        int actual = (new PermCheckSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionPermutationsOfRanges() {
        int[] A = new int[] { 2, 3, 4 };
        int expected = 0;
        int actual = (new PermCheckSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionDouble() {
        int[] A = new int[] { 1, 2 };
        int expected = 1;
        int actual = (new PermCheckSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionExtremeMax() {
        int[] A = new int[] { 1000000000 };
        int expected = 0;
        int actual = (new PermCheckSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

}