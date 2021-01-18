package codility.lessons.Lesson5_PrefixSums;

import codility.lessons.Lesson5_PrefixSums.Solutions.GenomicRangeQuerySlow62;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by peng.yang on ${Date}
 */
class GenomicRangeQuerySlow62Test {
    @Test
    void solution() {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] expected = {2, 4, 1};
        int[] actual = (new GenomicRangeQuerySlow62()).solution(S, P, Q);
        Assertions.assertArrayEquals(expected, actual);
    }

}