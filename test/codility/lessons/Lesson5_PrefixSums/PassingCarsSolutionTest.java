package codility.lessons.Lesson5_PrefixSums;

import codility.lessons.Lesson5_PrefixSums.Solutions.PassingCarsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class PassingCarsSolutionTest {
    @Test
    void solution() {
        int[] A = new int[] {0, 1, 0, 1, 1};
        int expected = 5;
        int actual = (new PassingCarsSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

}