package codility.exams.abrfrb674.test3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class Test3Test2 {
    private final int N_MAX = 50;
    private Test3Impl2 s = new Test3Impl2();

    @Test
    void test1() {
        int N = 2;
        String S = "1A 2F 1C";
        int expected = 2;
        int actual = s.solution(N, S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int N = 1;
        String S = "";
        int expected = 2;
        int actual = s.solution(N, S);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void test3() {
        int N = 2;
        String S = "1A 2F 1C 1D";
        int expected = 2;
        int actual = s.solution(N, S);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void test4() {
        int N = 2;
        String S = "1A 2F 1C 1D 1F";
        int expected = 1;
        int actual = s.solution(N, S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTestDuration() {
//        int[] A = new int[N_MAX];
//        for (int a = 0; a < A.length; a++) {
//            A[a] = ThreadLocalRandom.current().nextInt(0, N_MAX + 1);
//        }
        int N = 50;
        String S = "";
        Assertions.assertTimeout(Duration.ofMillis(7000), ()-> {
            int actual =(s.solution(N, S));
        });
    }
}
