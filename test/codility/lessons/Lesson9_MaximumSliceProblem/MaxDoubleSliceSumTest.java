package codility.lessons.Lesson9_MaximumSliceProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxDoubleSliceSumTest {
    MaxDoubleSliceSum s = new MaxDoubleSliceSum();

    @Test
    public void Test1() {
        int[] A = new int[] {3, 2, 6, -1, 4, 5, -1, 2};
        int expect = 17;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }
}
