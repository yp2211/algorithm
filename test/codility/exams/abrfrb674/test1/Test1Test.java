package codility.exams.abrfrb674.test1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Test1Test {
    private final int N_MAX = 200000;
    private Test1Impl s = new Test1Impl();

    @Test
    void test1() {
        int expected = 103;
        int actual = s.solution(130);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int A = 123456;
        int expected = 162534;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTestDuration() {
        int A = 100000000;
//        for (int a = 0; a < A.length; a++) {
//            A[a] = ThreadLocalRandom.current().nextInt(0, N_MAX + 1);
//        }

        Assertions.assertTimeout(Duration.ofMillis(7000), ()-> {
            int actual =(s.solution(A));
        });
    }
}
