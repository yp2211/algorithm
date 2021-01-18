package codility.lessons.Lesson3_TimeComplexity;

import codility.lessons.Lesson3_TimeComplexity.Solutions.PermMissingElemSolutionBucket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class PermMissingElemSolutionBucketTest {
    @Test
    void solution() {
        int[] A = new int[] {1, 2, 3, 5};
        int expected = 4;
        int actual = (new PermMissingElemSolutionBucket()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionEmpty() {
        int[] A = new int[] {};
        int expected = 1;
        int actual = (new PermMissingElemSolutionBucket()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionMissingLast() {
        int[] A = new int[] {1, 2, 3, 4};
        int expected = 5;
        int actual = (new PermMissingElemSolutionBucket()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionMissingFirst() {
        int[] A = new int[] {2, 3, 4};
        int expected = 1;
        int actual = (new PermMissingElemSolutionBucket()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionSingle() {
        int[] A = new int[] {2};
        int expected = 1;
        int actual = (new PermMissingElemSolutionBucket()).solution(A);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void solutionDouble() {
        int[] A = new int[] {2, 3};
        int expected = 1;
        int actual = (new PermMissingElemSolutionBucket()).solution(A);
        Assertions.assertEquals(expected, actual);
    }

}