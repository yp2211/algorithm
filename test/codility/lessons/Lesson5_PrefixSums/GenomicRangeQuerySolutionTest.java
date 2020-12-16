package codility.lessons.Lesson5_PrefixSums;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class GenomicRangeQuerySolutionTest {
    @Test
    void solution() {
        final char[] C = { 'A', 'C', 'G', 'T' };
        char[] cS = new char[100000];
        Random random = new Random();
        for (int i = 0; i < cS.length; i++) {
            // 通过d获取一个[0, 100)之间的整数
            final int r = random.nextInt(4);

            cS[i] = C[r];
        }
        String S = java.util.Arrays.toString(cS);

        int[] P = new int[50000];
        int[] Q = new int[50000];

        for (int i = 0; i < P.length; i++) {
            final double d = Math.random();
            // 通过d获取一个[0, 100)之间的整数
            final int p = random.nextInt(50000);

            P[i] = p;

            final int q = random.nextInt(100000 - p) + p;

            Q[i] = q;
        }
        assertTimeout(Duration.ofSeconds(1), () -> {
            (new GenomicRangeQuerySolution()).solution(S, P, Q);
        } );
    }

}