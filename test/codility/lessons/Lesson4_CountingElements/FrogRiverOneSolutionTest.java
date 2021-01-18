package codility.lessons.Lesson4_CountingElements;

import codility.lessons.Lesson4_CountingElements.Solutions.FrogRiverOneSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class FrogRiverOneSolutionTest {
    @Test
    void solutionExample() {
        int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;
        int expected = 6;
        int actual = (new FrogRiverOneSolution()).solution(X, A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionSigle() {
        int[] A = new int[] {1};
        int X = 1;
        int expected = 0;
        int actual = (new FrogRiverOneSolution()).solution(X, A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionExtremeFrog() {
        int[] A = new int[] {1, 3, 1, 4, 3, 5, 4};
        int X = 5;
        int expected = -1;
        int actual = (new FrogRiverOneSolution()).solution(X, A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionExtremeLeaves() {
        int[] A = new int[] {1, 1, 1, 1, 1, 1, 1};
        int X = 5;
        int expected = -1;
        int actual = (new FrogRiverOneSolution()).solution(X, A);
        Assertions.assertEquals(expected, actual);
    }

}