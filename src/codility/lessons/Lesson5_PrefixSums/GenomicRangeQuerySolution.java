package codility.lessons.Lesson5_PrefixSums;

import java.lang.reflect.Array;

/**
 * Created by peng.yang on ${Date}
 */
public class GenomicRangeQuerySolution extends AbstractGenomicRangeQuery {
    @Override
    public int[] solution(String S, int[] P, int[] Q) {
        int[] goal = new int[P.length];
        char[] C = S.toCharArray();
        for (int i = 0; i < P.length; i++) {
            int min = 4;
            for (int j = P[i]; j <= Q[i]; j++) {
                switch (C[j]) {
                    case 'A':
                        min = 1;
                        break;
                    case 'C':
                        if (2 < min) min = 2;
                        break;
                    case 'G':
                        if (3 < min) min = 3;
                        break;
                    case 'T':
                    default:
                        break;

                }
                if (min == 1) break;;
            }

            goal[i] = min;
        }

        return goal;
    }
}
