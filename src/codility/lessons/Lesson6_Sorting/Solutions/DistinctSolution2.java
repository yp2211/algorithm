package codility.lessons.Lesson6_Sorting.Solutions;

import codility.lessons.Lesson6_Sorting.IDistinct;

import java.util.Arrays;

/**
 * Created by peng.yang on ${Date}
 */
public class DistinctSolution2 implements IDistinct {

    @Override
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 1;

        // Time complexity: O(logN)
        // Space complexity: O(1);
        Arrays.sort(A);
        int writePoint = 0;
        int readPoint = 1;
        while (readPoint < A.length) {
            if (A[readPoint] == A[writePoint]) {
                readPoint++;
            } else {
                A[writePoint + 1] = A[readPoint];
                readPoint++;
                writePoint++;
            }
        }

        return writePoint + 1;
    }

}
