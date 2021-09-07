package codility.exams.b3h.test2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class solutionTest {
    @Test
    void solutionTest1() {
        solution s = new solution();
        int[] A = new int[] {1,1,3,3,3,4,5,5,5,5};
        int expected = 5;
        int actual = s.solution(A, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest2() {
        solution s = new solution();
        int[] A = new int[] {1,1,2,3,3,4,5,5,5,5};
        int expected = 4;
        int actual = s.solution(A, 2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest3() {
        solution s = new solution();
        int[] A = new int[] {1,1,3,3,3,4,5,5,5,5};
        int expected = 4;
        int actual = s.solution(A, 0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest4() {
        solution s = new solution();
        int[] A = new int[]{1,1,3,3,3,4,5,5,5,5,};
        int expected = 10;
        int actual = s.solution(A, 10);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void solutionTest5() {
        solution s = new solution();
        int[] A = new int[]{1};
        int expected = 1;
        int actual = s.solution(A, 1);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionTest6() {
        solution s = new solution();
        int[] A = new int[]{1};
        int expected = 1;
        int actual = s.solution(A, 0);
        Assertions.assertEquals(expected, actual);
    }
}
