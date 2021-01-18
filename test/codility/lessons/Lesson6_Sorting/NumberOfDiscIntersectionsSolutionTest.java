package codility.lessons.Lesson6_Sorting;

import codility.lessons.Lesson6_Sorting.Solutions.NumberOfDiscIntersectionsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class NumberOfDiscIntersectionsSolutionTest {
    @Test
    void solution() {
        int[] A = new int[] {1, 5, 2, 1, 4, 0};
        int expected = 11;
        int actual = (new NumberOfDiscIntersectionsSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

}