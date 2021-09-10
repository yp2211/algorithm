package codility.lessons.Lesson6_Sorting;

import codility.lessons.Lesson6_Sorting.Solutions.MaxProductOfThreeSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class MaxProductOfThreeSolutionTest {
    @Test
    void solution() {
        int[] A = new int[] {-3, 1, 2, -2, 5, 6};
        int expected = 60;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }
    @Test
    void solutionSimple1() {
        int[] A = new int[] {-5, -5, 5, 4};
        int expected = 125;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }
    @Test
    void solutionSimple2() {
        int[] A = new int[] {-5, -5, -1, -2, -3};
        int expected = -6;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }
    @Test
    void solutionSimple3() {
        int[] A = new int[] {-5, -5, 0, -2, -3};
        int expected = 0;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }
    @Test
    void solutionSimple4() {
        int[] A = new int[] {-5, 1, 5, 5, 4};
        int expected = 100;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }
    @Test
    void solutionSimple5() {
        int[] A = new int[] {1, 2, 3};
        int expected = 6;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }


    @Test
    void solutionSimple6() {
        int[] A = new int[] {-1, -3, 3, 1};
        int expected = 9;
        int actrual = (new MaxProductOfThreeSolution()).solution(A);
        Assertions.assertEquals(expected, actrual);
    }
}