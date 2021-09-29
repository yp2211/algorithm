package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercisesTest {
    Lesson10Exercises s = new Lesson10Exercises();
    @Test
    public void CountingDivisorsTest1() {
        int N = 36;
        int expected = 9; // 1, 2, 3, 4, 6, 9, 12, 18, 36
        int actual = s.CountingDivisors(N);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CountingDivisorsTest2() {
        int N = 24;
        int expected = 8; // 1, 2, 3, 4, 6, 8, 12, 24
        int actual = s.CountingDivisors(N);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void PrimalityTestTest1() {
        int N = 7;
        boolean expected = true;
        boolean actual = s.PrimalityTest(N);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void PrimalityTestTest2() {
        int N = 9;
        boolean expected = false;
        boolean actual = s.PrimalityTest(N);
        Assertions.assertEquals(expected, actual);
    }
}
