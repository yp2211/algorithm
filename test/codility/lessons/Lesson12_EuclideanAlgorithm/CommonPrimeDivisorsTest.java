package codility.lessons.Lesson12_EuclideanAlgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonPrimeDivisorsTest {
    CommonPrimeDivisors s = new CommonPrimeDivisors();
    @Test
    public void test1() {
        int[] A = new int[] {15, 10, 3};
        int[] B = new int[] {75, 30, 5};
        int expected = 1;
        int actual = s.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] A = new int[] {15, 10, 3, 150, 270};
        int[] B = new int[] {75, 30, 5, 180, 60};
        int expected = 3;
        int actual = s.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }
}
