package codility.lessons.Lesson3_TimeComplexity;

import codility.lessons.Lesson3_TimeComplexity.Solutions.TapeEquilibriumSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class TapeEquilibriumSolutionTest {
    @Test
    void solution() {
        int[] A = new int[] {3, 1, 2, 4, 3};
        int expected = 1;
        int actual = (new TapeEquilibriumSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
}