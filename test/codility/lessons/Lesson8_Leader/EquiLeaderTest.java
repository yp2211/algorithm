package codility.lessons.Lesson8_Leader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquiLeaderTest {
    EquiLeader s = new EquiLeader();

    /*
        A[0] = 4
        A[1] = 3
        A[2] = 4
        A[3] = 4
        A[4] = 4
        A[5] = 2
     */
    @Test
    public void Test1() {
        int[] A = new int[] {4,3,4,4,4,2};
        int expect = 2;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void Test2() {
        int[] A = new int[] {4,3,3,4,4,2};
        int expect = 0;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }


    @Test
    public void Test3() {
        int[] A = new int[] {4,3,3,4,4,4};
        int expect = 2;
        int actual = s.solution(A);
        Assertions.assertEquals(expect, actual);
    }
}
