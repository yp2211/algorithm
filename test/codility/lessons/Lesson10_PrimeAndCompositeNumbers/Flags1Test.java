package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Flags1Test {
    Flags1 s = new Flags1();
    @Test
    public void test1() {
        int[] A = new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int expected = 3;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] A = new int[] {1, 5, 3, 3, 3, 4, 3, 3, 3, 4, 1, 2, 3, 3, 4, 3, 3, 3, 6, 2};
        int expected = 4;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] A = new int[] {1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 6, 2};
        int expected = 2;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] A = new int[] {1, 5, 3, 4, 3, 4, 1, 6, 1, 5, 3, 4, 3, 4, 1, 6, 2};
        int expected = 4;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test5() {
        int[] A = new int[] {1, 1000000000, 999999998, 999999999, 3, 4, 1, 2, 3, 4, 6, 2};
        int expected = 3;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] A = new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4}; // length = 10
        int[] B = new int[400000];
        for (int i = 0; i < B.length; i+=10) {
            for (int j = 0; j < 10; j++) {
                B[i+j] = A[j];
            }
        }
        int expected = 3*40000;
        int actual = s.solution(B);
        Assertions.assertEquals(expected, actual);
    }
}
