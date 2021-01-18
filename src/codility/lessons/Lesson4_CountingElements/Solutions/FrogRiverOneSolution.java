package codility.lessons.Lesson4_CountingElements.Solutions;

import codility.lessons.Lesson4_CountingElements.IFrogRiverOne;

/**
 * Created by peng.yang on ${Date}
 */
public class FrogRiverOneSolution implements IFrogRiverOne {
    @Override
    public int solution(int X, int[] A) {
        int goal = -1;
        int B[] = new int[X + 1];
        java.util.Arrays.fill(B, -1);
        for (int i = 0; i < A.length; i++) {
            if (B[A[i]] < 0 || B[A[i]] > i) {
                B[A[i]] = i;
            }
        }

        for (int j = 1; j < B.length; j ++) {
            int anB = B[j];
            if (anB < 0) {
                goal = -1;
                break;
            } else {
                goal = goal < anB ? anB : goal;
            }
        }

        return goal;
    }
}
