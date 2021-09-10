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
        String expected = "a";
        String actual = s.solution("aba");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String expected = "z";
        String actual = s.solution("zz");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void test3() {
        String expected = "i";
        String actual = s.solution("codility");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test4() {
        String expected = "z";
        String actual = s.solution("abcdefghijklmnopqrstuvwxyzz");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionTestDuration() {
        String A = "abcdefghijklmnopqrstuvwxyzz";

        Assertions.assertTimeout(Duration.ofMillis(7000), ()-> {
            String actual = (s.solution(A));
        });
    }
}
