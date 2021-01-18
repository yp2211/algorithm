package codility.lessons.Lesson4_CountingElements.Solutions;

import codility.lessons.Lesson4_CountingElements.IMaxCounters;

/**
 * Created by peng.yang on ${Date}
 */
public class MaxCountersSolution implements IMaxCounters {
    @Override
    public int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int currentMaximumValue = 0;
        int minValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                if (minValue < currentMaximumValue) {
                    minValue = currentMaximumValue;
                }
            } else {
                if (B[A[i] - 1] < minValue) {
                    B[A[i] - 1] = minValue;
                }

                B[A[i] - 1] += 1;
                if (B[A[i] - 1] > currentMaximumValue) currentMaximumValue = B[A[i] - 1];
            }
        }
        for (int j = 0; j < B.length; j++) {
            B[j] = B[j] < minValue ? minValue : B[j];
        }

        return B;
    }
}
