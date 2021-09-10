package codility.lessons.Lesson7_StackAndQueues;

import codility.lessons.Lesson7_StacksAndQueues.StoneWall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StoneWallTest {
    StoneWall s = new StoneWall();

    @Test
    void Test1() {
        int[] A = new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8};
        int expected = 7;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

}
