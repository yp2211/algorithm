package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class MinPerimeterRectangleTest {
    MinPerimeterRectangle s = new MinPerimeterRectangle();

    @Test
    public void test1() {
        int N = 30;
        int expected = 22;
        int actual = s.solution(N);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int N = 1000000000;
        Assertions.assertTimeout(Duration.ofMillis(3000), ()-> {
            System.out.println(s.solution(N));
        });
    }
}
