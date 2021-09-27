package codility.lessons.Lesson11_SieveOfEratosthenes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class CountSemiprimesTest {
    CountSemiprimes s = new CountSemiprimes();
    @Test
    public void test1() {
        int N = 26;
        int[] P = new int[] { 1,  4, 16};
        int[] Q = new int[] {26, 10, 20};
        int[] expected = new int[] {10, 4, 0};
        int[] actual = s.solution(N, P, Q);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void test9() {
        int N = 50000;
        int[] P = new int[30000];
        int[] Q = new int[30000];
        for (int i = 0; i < 30000; i++) {
            P[i] = Math.max(ThreadLocalRandom.current().nextInt(0, 50000 + 1), 1);
            Q[i] = 50000;
        }
        Assertions.assertTimeout(Duration.ofMillis(1000), ()-> {
            int[] actual = s.solution(N, P, Q);
        });
    }

}
