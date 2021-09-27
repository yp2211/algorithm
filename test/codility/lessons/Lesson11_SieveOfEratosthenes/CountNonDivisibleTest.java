package codility.lessons.Lesson11_SieveOfEratosthenes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountNonDivisibleTest {
    CountNonDivisible s = new CountNonDivisible();
    @Test
    public void test1() {
        int[] A = new int[] {3, 1, 2, 3, 6};
        int[] expected = new int[] {2, 4, 3, 2, 0};
        int[] actual = s.solution(A);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] A = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
        int[] expected = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32};
        int[] actual = s.solution(A);
        Assertions.assertArrayEquals(expected, actual);
    }
}
