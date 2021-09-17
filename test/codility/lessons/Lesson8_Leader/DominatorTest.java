package codility.lessons.Lesson8_Leader;

import org.junit.jupiter.api.Test;

public class DominatorTest {
    Dominator s = new Dominator();
    /*
        A[0] = 3    A[1] = 4    A[2] =  3
        A[3] = 2    A[4] = 3    A[5] = -1
        A[6] = 3    A[7] = 3

        0, 2, 4, 6 and 7
     */
    @Test
    public void Test1() {
        int[] A = new int[] {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(s.solution(A));
    }

    @Test
    public void Test2() {
        int[] A = new int[] {1};
        System.out.println(s.solution(A));
    }
}
