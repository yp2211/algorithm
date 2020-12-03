package codility.lessons.Lesson2_Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class OddOccurrencesInArrayTest {
    @Test
    void solution() {
        int[] A = new int[] { 9, 3, 9, 3, 9, 7, 9};
        int expected = 7;
        int actual = (new OddOccurrencesInArray()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

}