package codility.lessons.Lesson6_Sorting;

import codility.lessons.Lesson6_Sorting.Solutions.DistinctSolution2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by peng.yang on ${Date}
 */
class DistinctSolution2Test {
    DistinctSolution2 s = new DistinctSolution2();
    @Test
    void solutionSample() {
        int[] A = new int[] {2, 1, 1, 2, 3, 1};
        int expeted = 3;
        int actual = s.solution(A);
        System.out.println(Arrays.toString(A));
        Assertions.assertEquals(expeted, actual);
    }

    @Test
    void solutionMaxValue() {
        int[] A = new int[] {-1000000, 1, 1, 2, 3, 1000000};
        int expeted = 5;
        int actual = s.solution(A);
        System.out.println(Arrays.toString(A));
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
        int actual = s.solution(A);
        Assertions.assertEquals(expeted, actual);
    }
}