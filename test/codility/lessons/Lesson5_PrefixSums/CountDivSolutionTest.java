package codility.lessons.Lesson5_PrefixSums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class CountDivSolutionTest {
    @Test
    void solution() {
        int A = 6;
        int B = 11;
        int K = 2;
        int expected = 3;
        int actual = (new CountDivSolution()).solution(A, B, K);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionEmpty() {
        int A = 6;
        int B = 11;
        int K = 100;
        int expected = 0;
        int actual = (new CountDivSolution()).solution(A, B, K);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionSingle() {
        int A = 6;
        int B = 6;
        int K = 6;
        int expected = 1;
        int actual = (new CountDivSolution()).solution(A, B, K);
        Assertions.assertEquals(expected, actual);
    }

}