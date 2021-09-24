package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeaksIntuitiveTest {
    PeaksIntuitive s = new PeaksIntuitive();
    @Test
    public void test1() {
        int[] A = new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        int expected = 3;
        int actual = s.solution(A);
        Assertions.assertEquals(expected, actual);
    }

}
