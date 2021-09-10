package codility.lessons.Lesson7_StackAndQueues;

import codility.lessons.Lesson7_StacksAndQueues.Fish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FishTest {
    Fish s = new Fish();
    @Test
    void Test1() {
        int[] A = new int[]{4,3,2,1,5};
        int[] B = new int[]{0,1,0,0,0};
        int expected = 2;
        int actual = s.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Test2() {
        int[] A = new int[]{3,2,1};
        int[] B = new int[]{1,0,0};
        int expected = 1;
        int actual = s.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void Test3() {
        int[] A = new int[]{3,2,1,4};
        int[] B = new int[]{1,0,0,0};
        int expected = 1;
        int actual = s.solution(A, B);
        Assertions.assertEquals(expected, actual);
    }
}
