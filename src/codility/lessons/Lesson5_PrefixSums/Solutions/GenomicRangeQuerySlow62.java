package codility.lessons.Lesson5_PrefixSums.Solutions;

import codility.lessons.Lesson5_PrefixSums.IGenomicRangeQuery;

/**
 * https://app.codility.com/demo/results/trainingDMY4GR-QXF/
 * Created by peng.yang on ${Date}
 */
public class GenomicRangeQuerySlow62 implements IGenomicRangeQuery {
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
