package codility.lessons.Lesson3_TimeComplexity.Solutions;

import codility.lessons.Lesson3_TimeComplexity.IPermMissingElem;

/**
 * Created by peng.yang on ${Date}
 */
public class PermMissingElemSolutionSort implements IPermMissingElem {
    @Override
    public int solution(int[] A) {
        if (A.length == 0) return 1;

        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if ((i + 1) != A[i]) return i + 1;
        }
        return A.length + 1;
    }
}
