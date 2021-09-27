package codility.lessons.Lesson11_SieveOfEratosthenes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountNonDivisibleIntuitiveTest {
    CountNonDivisibleIntuitive s = new CountNonDivisibleIntuitive();
    @Test
    public void test1() {
        int[] A = new int[] {3, 1, 2, 3, 6};
        int[] expected = new int[] {2, 4, 3, 2, 0};
        int[] actual = s.solution(A);
        Assertions.assertArrayEquals(expected, actual);
    }
}
