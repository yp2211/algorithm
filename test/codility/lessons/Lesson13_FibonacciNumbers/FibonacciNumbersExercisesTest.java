package codility.lessons.Lesson13_FibonacciNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FibonacciNumbersExercisesTest {
    FibonacciNumbersExercises s = new FibonacciNumbersExercises();
    @Test
    public void testFibonacciNumbers() {
        int n = 11;
        int expected = 89;
        int actual = s.fibonacci(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciDynamic() {
        int n = 11;
        int expected = 89;
        int actual = s.fibonacciDynamic(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciDynamic18() {
        int n = 18;
        int expected = 2584;
        int actual = s.fibonacciDynamic(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciDynamic31() {
        int n = 31;
        int expected = 1346269;
        int actual = s.fibonacciDynamic(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciMatrix() {
        int n = 11;
        int expected = 89;
        int actual = s.fibonacciMatrix(n);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testFibonacciMatrix18() {
        int n = 18;
        int expected = 2584;
        int actual = s.fibonacciMatrix(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFibonacciMatrix31() {
        int n = 31;
        int expected = 1346269;
        int actual = s.fibonacciMatrix(n);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testFibonacciFormula() {
        int n = 11;
        int expected = 89;
        int actual = s.fibonacciFormula(n);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testFibonacciFormula18() {
        int n = 18;
        int expected = 2584;
        int actual = s.fibonacciFormula(n);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testExercise() {
        /*
        [0,     1,      1,      2,      3,      5,      8,      13,       21, 34,
        55,     89,     144,    233,    377,    610,    987,    1597,   2584, 4181,
        6765,   10946, 17711,   28657, 46368,   75025,  121393, 196418, 317811, 514229,
        832040, 1346269]
         */
        int[] X = new int[] {832040+377, 832040+610+4, 610+5,832040+10946,832040+10946+9};
        int[][] actual = s.exercise(X);
        Assertions.assertEquals(14, actual[0][0]);
        Assertions.assertEquals(30, actual[0][1]);
        Assertions.assertEquals(0, actual[1][0]);
        Assertions.assertEquals(0, actual[1][1]);
        Assertions.assertEquals(5, actual[2][0]);
        Assertions.assertEquals(15, actual[2][1]);
        Assertions.assertEquals(21, actual[3][0]);
        Assertions.assertEquals(30, actual[3][1]);
        Assertions.assertEquals(0, actual[4][0]);
        Assertions.assertEquals(0, actual[4][1]);
    }
}
