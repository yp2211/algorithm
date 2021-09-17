package codility.lessons.Lesson8_Leader;

import org.junit.jupiter.api.Test;

public class Dominator1Test {
    Dominator1 s = new Dominator1();
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

    @Test
    public void Test3() {
        int[] A = new int[] {3, 3, 3, 4, 4, 4, 4};
        System.out.println(s.solution(A));
    }

    @Test
    public void Test4() {
        int[] A = new int[] {4, 4, 2, 3, 3};
        System.out.println(s.solution(A));
    }

}
