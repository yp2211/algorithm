package codility.lessons.Lesson13_FibonacciNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibFrogTest {
    FibFrog s = new FibFrog();

    @Test public void test1(){
        int[] A = new int[] {0,0,0,1,1,0,1,0,0,0,0};
        int expected = 3;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

    @Test public void testExtreme_large_ones_zeros(){
        int[] A = new int[100000];
        int expected = -1;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
}
