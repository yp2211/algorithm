package codility.exams.abrfrb674.test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Test2Test {
    private final int N_MAX = 200000;
    private Test2Impl s = new Test2Impl();

    @Test
    void test1() {
        int expected = 0;
        int actual = s.solution(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTestDuration() {
        int[] A = new int[N_MAX];
        for (int a = 0; a < A.length; a++) {
            A[a] = ThreadLocalRandom.current().nextInt(0, N_MAX + 1);
        }

        Assertions.assertTimeout(Duration.ofMillis(7000), ()-> {
            int actual =(s.solution(A));
        });
    }
}
