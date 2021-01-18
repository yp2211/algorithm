package codility.lessons.Lesson2_Arrays;

import codility.lessons.Lesson2_Arrays.Solutions.CyclicRotationSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class CyclicRotationTest {
    @Test
    void CyclicRotationTest1() {
        int[] A = new int[] { 3, 8, 9, 7, 6 };
        int K = 3;
        int[] expected = new int[] { 9, 7, 6, 3, 8 };
        int[] actual = (new CyclicRotationSolution()).solution(A, K);

        System.out.print("{");
        for (int t = 0; t < actual.length; t++) {
            System.out.print(actual[t]);
            if (t < actual.length - 1) System.out.print(", ");
        }
        System.out.print("}");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void CyclicRotationTest2() {
        int[] A = new int[] { 0, 0, 0};
        int K = 1;
        int[] expected = new int[] { 0, 0, 0 };
        int[] actual = (new CyclicRotationSolution()).solution(A, K);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void CyclicRotationTest3() {
        int[] A = new int[] { 1, 2, 3, 4 };
        int K = 4;
        int[] expected = new int[] { 1, 2, 3, 4 };
        int[] actual = (new CyclicRotationSolution()).solution(A, K);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void CyclicRotationTest4() {
        int[] A = new int[] { };
        int K = 4;
        int[] expected = new int[] {  };
        int[] actual = (new CyclicRotationSolution()).solution(A, K);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void CyclicRotationTest5() {
        int[] A = new int[] { 1, 2, 3, 4 };
        int K = 0;
        int[] expected = new int[] { 1, 2, 3, 4 };
        int[] actual = (new CyclicRotationSolution()).solution(A, K);
        Assertions.assertArrayEquals(expected, actual);
    }

}