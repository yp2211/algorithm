package codility.lessons.Lesson6_Sorting.Solutions;

import codility.lessons.Lesson6_Sorting.INumberOfDiscIntersections;

/**
 * Created by peng.yang on ${Date}
 */
public class NumberOfDiscIntersectionsSolution56 implements INumberOfDiscIntersections {

    /*
     * N is an integer within the range [0..100,000];
     * each element of array A is an integer within the range [0..2,147,483,647].
     */
    @Override
    public int solution(int[] A) {
        final int COUNT_MAX = 10000000;
        int count = 0;

        for (int m = 0; m < A.length - 1; m++) {
            long leftM = 0l + m - A[m], rightM = 0l + m + A[m];
            for (int n = m + 1; n < A.length; n++) {
                long leftN = 0l + n - A[n], rightN = 0l + n + A[n];
                if ((leftN <= rightM && rightN >= leftM)
                        || (leftM <= rightN && rightM >= leftN)) {
                    count++;
                }
                if (count > COUNT_MAX) return - 1;
            }
        }

        if(count > COUNT_MAX) return -1;
        else return count;
    }
}
