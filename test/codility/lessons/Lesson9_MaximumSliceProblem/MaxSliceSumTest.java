package codility.lessons.Lesson9_MaximumSliceProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxSliceSumTest {
    MaxSliceSum s = new MaxSliceSum();
    @Test
    public void Test1() {
        int[] A = new int[] {3, 2, -6, 4, 0};
        int expect = 5;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test2() {
        int[] A = new int[] {-6, 3, 2, 4, 0};
        int expect = 9;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }


    @Test
    public void Test3() {
        int[] A = new int[] {-6, -2, 3, -2, 2, 4, 0};
        int expect = 7;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test4() {
        int[] A = new int[] {-6};
        int expect = -6;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test5() {
        int[] A = new int[] {-6, -3, -2};
        int expect = -2;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test6() {
        int[] A = new int[] {-6, 4, -1, 4, -2, 2, 4, 0};
        int expect = 11;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test7() {
        int[] A = new int[] {3, -1, 2, 4, -2, 2, 4, 0};
        int expect = 12;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }


    @Test
    public void Test8() {
        int[] A = new int[] {-3, -1, 2, -3, 4, 2, 0};
        int expect = 6;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test9() {
        int[] A = new int[] {2, 1, -4, 1, 2, 1};
        int expect = 4;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test10() {
        int[] A = new int[] {2, 1, -4, 1, 2, -4, 1, 3, -1, 2, 4, -2, 2, 4, 0};
        int expect = 13;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }


    @Test
    public void Test11() {
        int[] A = new int[] {-6, -2, -3};
        int expect = -2;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }
}
