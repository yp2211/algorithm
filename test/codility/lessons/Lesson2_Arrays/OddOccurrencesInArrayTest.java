package codility.lessons.Lesson2_Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class OddOccurrencesInArrayTest {
    private final static int ELEMENT_MIN_N = 1;
    private final static int ELEMENT_MAX_N = 1000000;
    private final static int ELEMENT_MIN_VALUE = 1;
    private final static int ELEMENT_MAX_VALUE = 1000000000;

    @Test
    void solution() {
        int[] A = new int[] { 9, 3, 9, 3, 9, 7, 9};
        int expected = 7;
        int actual = (new OddOccurrencesInArray()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

    /*
     * ELEMENT_MAX_N
     */
    @Test
    void solution1() {
        int expected = 500000000;
        int[] A = new int[ELEMENT_MAX_N - 1];
        A[0] = expected;
        for (int i = 1; i < ELEMENT_MAX_N - 1;) {
            int temp = RandomInteger(ELEMENT_MIN_VALUE, ELEMENT_MAX_VALUE);
            if (temp != expected) {
                A[i] = temp;
                A[i + 1] = temp;
                i += 2;
            }
        }
        long start = System.currentTimeMillis();
//        System.out.println(start);
        int actual = (new OddOccurrencesInArray()).solution(A);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        Assertions.assertEquals(expected, actual);

    }

    private static int RandomInteger(int min, int max) {
        return (new Random()).nextInt(max) + min;
    }

}