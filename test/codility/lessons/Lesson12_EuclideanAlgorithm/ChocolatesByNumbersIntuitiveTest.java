package codility.lessons.Lesson12_EuclideanAlgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChocolatesByNumbersIntuitiveTest {
    ChocolatesByNumbersIntuitive s = new ChocolatesByNumbersIntuitive();
    @Test
    public void test1() {
        int N = 10, M = 4;
        int expected = 5;
        int actual = s.solution(N, M);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testLarge2() {
        int N = (int)(Math.pow(3,9)*Math.pow(2,14)), M=(int)(Math.pow(2,14)*Math.pow(2,14));
        int expected = 19683;
        int actual = s.solution(N, M);
        Assertions.assertEquals(expected, actual);
    }
}
