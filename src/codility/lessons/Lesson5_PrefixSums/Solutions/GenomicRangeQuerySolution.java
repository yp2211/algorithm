package codility.lessons.Lesson5_PrefixSums.Solutions;

import codility.lessons.Lesson5_PrefixSums.IGenomicRangeQuery;

import java.lang.reflect.Array;

/**
 * Created by peng.yang on ${Date}
 */
public class GenomicRangeQuerySolution implements IGenomicRangeQuery {
    @Override
    public int[] solution(String S, int[] P, int[] Q) {
        int[] goal = new int[P.length];
        int[][] prefixSums = new int[3][S.length() + 1];
        int[] DNA = new int[]{1, 2, 3, 4};
        short a, c, g;
        for (int i = 0; i < S.length(); i++) {
            a = 0;
            c = 0;
            g = 0;
            switch (S.charAt(i)) {
                case 'A':
                    a = 1;
                    break;
                case 'C':
                    c = 1;
                    break;
                case 'G':
                    g = 1;
                    break;
                default:
                    break;
            }
            prefixSums[0][i + 1] = prefixSums[0][i] + a;
            prefixSums[1][i + 1] = prefixSums[1][i] + c;
            prefixSums[2][i + 1] = prefixSums[2][i] + g;
        }

        for (int j = 0; j < P.length; j++) {
            int from = P[j];
            int to = Q[j] + 1;
            if (prefixSums[0][to] - prefixSums[0][from] > 0) {
                goal[j] = DNA[0];
            } else if (prefixSums[1][to] - prefixSums[1][from] > 0) {
                goal[j] = DNA[1];
            } else if (prefixSums[2][to] - prefixSums[2][from] > 0) {
                goal[j] = DNA[2];
            } else {
                goal[j] = DNA[3];
            }
        }

        return goal;
    }

}
