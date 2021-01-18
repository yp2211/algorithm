package codility.lessons.Lesson4_CountingElements.Solutions;

import codility.lessons.Lesson4_CountingElements.IMissingInteger;

/**
 * Created by peng.yang on ${Date}
 */
public class MissingIntegerSolution implements IMissingInteger {
    @Override
    public int solution(int[] A) {
        boolean[] B = new boolean[1000001];
        java.util.Arrays.fill(B, false);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                B[A[i]] = true;
            }
        }
        for (int j = 1; j < B.length; j++) {
            if (!B[j]) return j;
        }

        return 1000001;
    }
}
