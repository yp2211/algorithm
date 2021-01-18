package codility.lessons.Lesson5_PrefixSums.Solutions;

import codility.lessons.Lesson5_PrefixSums.IMinAvgTwoSlice;

/**
 * Created by peng.yang on ${Date}
 */
public class MinAvgTwoSliceSolution implements IMinAvgTwoSlice {
    @Override
    public int solution(int[] A) {
        int goal = 0;
        int[] P = new int[A.length + 1];
        P[0] = 0;
        for (int i = 0; i < A.length; i++) {
            P[i + 1] = P[i] + A[i];
        }

        double minAvg = 10000;
        for(int j = 0; j < A.length - 1; j++) {
            double currentAvg2 = (double)(P[j + 2] - P[j]) / 2;
            if (currentAvg2 < minAvg) {
                minAvg = currentAvg2;
                goal = j;
            }

            if (j == A.length - 2) break;;

            double currentAvg3 = (double)(P[j + 3] - P[j]) / 3;
            if (currentAvg3 < minAvg) {
                minAvg = currentAvg3;
                goal = j;
            }
        }

        return goal;
    }
}
