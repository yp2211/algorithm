package codility.lessons.Lesson5_PrefixSums;

import codility.lessons.Lesson5_PrefixSums.Solutions.MinAvgTwoSliceSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class MinAvgTwoSliceSolutionTest {
    @Test
    void solution() {
        int[] A = new int[] {
               4,
               2,
               2,
               5,
               1,
               5,
               8
        };
        int expeted = 1;
        int actual = (new MinAvgTwoSliceSolution()).solution(A);
        Assertions.assertEquals(expeted, actual);
    }

}