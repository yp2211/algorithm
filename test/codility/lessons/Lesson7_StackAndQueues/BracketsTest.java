package codility.lessons.Lesson7_StackAndQueues;

import codility.lessons.Lesson7_StacksAndQueues.Brackets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BracketsTest {
    Brackets s = new Brackets();

    @Test
    void Test1() {
        String A = "{[()()]}";
        int expected = 1;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void Test2() {
        String A = "([)()]";
        int expected = 0;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }
}
