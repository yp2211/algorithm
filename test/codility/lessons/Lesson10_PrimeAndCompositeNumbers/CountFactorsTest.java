package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class CountFactorsTest {
    CountFactors s = new CountFactors();
    @Test
    public void test1() {
        int N = 2147483647;
        Assertions.assertTimeout(Duration.ofMillis(6000), ()-> {
            System.out.println(s.solution(N));
        });
    }
}
