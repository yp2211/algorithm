package codility.exams.b3h.test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class test3Test {
    private final int N_MAX = 200000;
    private Test3ImplOld s = new Test3ImplOld();

    @Test
    void solutionTest1() {
        int[] A = new int[] {1,2,3};
        int[] B = new int[] {0,0,0};

        int expected = 0;
        int actual =(s.solution(A, B));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest2() {
        int[] A = new int[] {0,1,2,4,5};
        int[] B = new int[] {2,3,3,3,2};

        int expected = 3;
        int actual =(s.solution(A, B));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest3() {
        int[] A = new int[]{2,3,3,4};
        int[] B = new int[]{1,1,0,0};
        int expected = -1;
        int actual =(s.solution(A, B));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest4() {
        // Circle 1-->0-->3-->1
        int[] A = new int[] {1,2,0,4,5,0,0,2};
        int[] B = new int[] {0,0,3,3,3,1,2,1};

        int expected = 3;
        int actual =(s.solution(A, B));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest5() {
        // double Rome (0, 3)
        int[] A = new int[]{1,2,0,4,5,0,0,2,3};
        int[] B = new int[]{0,0,3,3,3,1,2,1,1};

        int expected = 0;
        int actual =(s.solution(A, B));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest6() {
        // Single City
        int[] A = new int[]{1,2,3};
        int[] B = new int[]{0,2,0};

        int expected = -1;
        int actual =(s.solution(A, B));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTestDuration() {
        int[] A = new int[N_MAX];
        for (int a = 0; a < A.length; a++) {
            A[a] = ThreadLocalRandom.current().nextInt(0, N_MAX + 1);
        }
        int[] B = new int[N_MAX];
        for (int b = 0; b < B.length; b++) {
            B[b] = ThreadLocalRandom.current().nextInt(0, N_MAX + 1);
        }

        Assertions.assertTimeout(Duration.ofMillis(7000), ()-> {
            int actual =(s.solution(A, B));
        });
    }
}
