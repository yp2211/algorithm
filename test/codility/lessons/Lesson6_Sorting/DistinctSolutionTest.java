package codility.lessons.Lesson6_Sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class DistinctSolutionTest {
    @Test
    void solutionSample() {
        int[] A = new int[] {2, 1, 1, 2, 3, 1};
        int expeted = 3;
        int actual = (new DistinctSolution()).solution(A);
        Assertions.assertEquals(expeted, actual);
    }

    @Test
    void solutionMaxValue() {
        int[] A = new int[] {-1000000, 1, 1, 2, 3, 1000000};
        int expeted = 5;
        int actual = (new DistinctSolution()).solution(A);
        Assertions.assertEquals(expeted, actual);
    }
    @Test
    void solutionMaxDistinct() {
        int N = 100000;
        int MIN = -1000000;
        int MAX = 1000000;

        int[] A = new int[N];
        int a = MIN;
        for (int i = 0; i < A.length; i++) {
            A[i] = a + i;
        }
        int expeted = N;
        int actual = (new DistinctSolution()).solution(A);
        Assertions.assertEquals(expeted, actual);
    }
}