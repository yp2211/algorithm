package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeaksTest {
    Peaks s = new Peaks();
    @Test
    public void test1() {
        int[] A = new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}; // N = 12
        int expected = 3;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int[] A = new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2, 3, 4, 6, 2}; // N = 16
        int expected = 4;
        int actual = s.solution(A);
        System.out.println(actual);
        Assertions.assertEquals(expected, actual);
    }
}
