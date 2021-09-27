package codility.lessons.Lesson11_SieveOfEratosthenes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountSemiprimesIntuitiveTest {
    CountSemiprimesIntuitive s = new CountSemiprimesIntuitive();
    @Test
    public void test1() {
        int N = 26;
        int[] P = new int[] { 1,  4, 16};
        int[] Q = new int[] {26, 10, 20};
        int[] expected = new int[] {10, 4, 0};
        int[] actual = s.solution(N, P, Q);
        Assertions.assertArrayEquals(expected, actual);
    }
}
