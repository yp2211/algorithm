package codility.demo;

import codility.demo.solutions.GetSmallestPositiveIntegerSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class GetSmallestPositiveIntegerTest {
    /*
     * given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     */
    @Test
    void solutionTest1() {

        int expected = 5;
        int actual = new GetSmallestPositiveIntegerSolution().solution(new int[]{1, 3, 6, 4, 1, 2});
        Assertions.assertEquals(expected, actual);
    }

    /*
     * Given A = [1, 2, 3], the function should return 4.
     */
    @Test
    void solutionTest2() {
        int expected = 4;
        int actual = new GetSmallestPositiveIntegerSolution().solution(new int[]{1, 2, 3});
        Assertions.assertEquals(expected, actual);
    }

    /*
     * Given A = [−1, −3], the function should return 1.
     */
    @Test
    void solutionTest3() {
        int expected = 1;
        int actual = new GetSmallestPositiveIntegerSolution().solution(new int[]{-1, -3});
        Assertions.assertEquals(expected, actual);
    }
}
