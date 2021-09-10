package codility.lessons.Lesson7_StackAndQueues;

import codility.lessons.Lesson7_StacksAndQueues.Nesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NestingTest {
    Nesting s = new Nesting();
    @Test
    void Test1() {
        String S = "(()(())())";
        int expected = 1;
        int actual = s.solution(S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Test2() {
        String S = "())";
        int expected = 0;
        int actual = s.solution(S);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void Test3() {
        String S = "(()(())())(";
        int expected = 0;
        int actual = s.solution(S);
        Assertions.assertEquals(expected, actual);
    }
}
