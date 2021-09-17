package codility.lessons.Lesson9_MaximumSliceProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProfitTest {
    MaxProfit s = new MaxProfit();
    @Test
    public void Test1() {
        int[] A = new int[] {23171, 21011, 21123, 21366, 21013, 21367};
        int expect = 356;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test2() {
        int[] A = new int[] {23171, 21011, 21123, 21366, 21367, 21010, 21013, 21365};
        int expect = 356;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }
}
