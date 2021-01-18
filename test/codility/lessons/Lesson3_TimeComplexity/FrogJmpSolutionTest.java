package codility.lessons.Lesson3_TimeComplexity;

import codility.lessons.Lesson3_TimeComplexity.Solutions.FrogJmpSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class FrogJmpSolutionTest {
    @Test
    void solution() {
        int X = 10;
        int Y = 85;
        int D = 30;
        int expeted = 3;
        int actual = (new FrogJmpSolution()).solution(X, Y, D);
        Assertions.assertEquals(expeted, actual);
    }
    @Test
    void solution2() {
        int X = 1;
        int Y = 1000000000;
        int D = 30;
        int expeted = 33333334;
        int actual = (new FrogJmpSolution()).solution(X, Y, D);
        Assertions.assertEquals(expeted, actual);
    }

}