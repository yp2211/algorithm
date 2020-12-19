package codility.lessons.Lesson4_CountingElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class MaxCountersSolutionTest {
    @Test
    void solutionExample() {
        int[] A = new int[] {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        int[] expected = new int[] {3, 2, 2, 4, 2};
        int[] actual = (new MaxCountersSolution()).solution(N, A);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void solutionExtremeLarge() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i + 1;
        }
        int N = 100000;
        int[] expected = new int[100000];
        java.util.Arrays.fill(expected, 1);
        int[] actual = (new MaxCountersSolution()).solution(N, A);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void solutionExtremeLarge1() {
        int N = 100000;
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = N + 1;
        }
        int[] expected = new int[100000];
        java.util.Arrays.fill(expected, 0);
        int[] actual = (new MaxCountersSolution()).solution(N, A);
        Assertions.assertArrayEquals(expected, actual);
    }


}