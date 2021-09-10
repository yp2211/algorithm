package codility.lessons.Lesson6_Sorting.Solutions;

import codility.lessons.Lesson6_Sorting.ITriangle;

public class Triangle implements ITriangle {
    /*
     * https://app.codility.com/demo/results/training7535QW-VQY/
     */
    @Override
    public int solution(int[] A) {
        java.util.Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            if ((long)A[i - 2] + A[i - 1] > A[i]) {
                return 1;
            }
        }
        return 0;
    }
}
