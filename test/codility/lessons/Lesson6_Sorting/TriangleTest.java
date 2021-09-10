package codility.lessons.Lesson6_Sorting;

import codility.lessons.Lesson6_Sorting.Solutions.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    Triangle s = new Triangle();
    @Test
    void Test1() {
        /*
            A[0] = 10    A[1] = 2    A[2] = 5
            A[3] = 1     A[4] = 8    A[5] = 20
         */
        int[] A = new int[] {10,2,5,1,8,20};
        int expected = 1;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Test2() {
        /*
            A[0] = 10    A[1] = 50    A[2] = 5
            A[3] = 1
         */
        int[] A = new int[] {10,50,5,1};
        int expected = 0;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Test3() {
        int[] A = new int[] {-1,20,15};
        int expected = 0;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void Test4() {
        int[] A = new int[] {2147483645,2147483646,2147483647};
        int expected = 1;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
}
