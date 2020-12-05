package codility.lessons.Lesson4_CountingElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class MaxCountersSlow77Test {
    @Test
    void solutionExample() {
        int[] A = new int[] {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        int[] expected = new int[] {3, 2, 2, 4, 2};
        int[] actual = (new MaxCountersSlow77()).solution(N, A);
        Assertions.assertArrayEquals(expected, actual);
    }
}