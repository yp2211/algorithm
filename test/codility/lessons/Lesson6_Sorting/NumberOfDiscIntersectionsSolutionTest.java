package codility.lessons.Lesson6_Sorting;

import codility.lessons.Lesson6_Sorting.Solutions.NumberOfDiscIntersectionsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * Created by peng.yang on ${Date}
 */
class NumberOfDiscIntersectionsSolutionTest {
    final int N_MAX = 100000;
    final int V_MAX = 2147483647;
    NumberOfDiscIntersectionsSolution s = new NumberOfDiscIntersectionsSolution();
    @Test
    void solution() {
        int[] A = new int[] {1, 5, 2, 1, 4, 0};
        int expected = 11;
        int actual = (new NumberOfDiscIntersectionsSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Test1() {
        int[] A = new int[] {0,1};
        int expected = 1;
        int actual = (new NumberOfDiscIntersectionsSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void Test2() {
        int[] A = new int[] {2147483647,2147483647};
        int expected = 1;
        int actual = (new NumberOfDiscIntersectionsSolution()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTestDuration() {
        int[] A = new int[N_MAX];
        for (int i = 0; i < N_MAX; i++) {
            A[i] = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, V_MAX);
//            A[a] = 0;
        }
        Assertions.assertTimeout(Duration.ofMillis(3000), ()-> {
            int actual =(s.solution(A));
            System.out.println(actual);
        });
    }
}