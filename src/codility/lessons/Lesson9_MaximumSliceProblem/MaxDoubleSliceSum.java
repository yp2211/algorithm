package codility.lessons.Lesson9_MaximumSliceProblem;

public class MaxDoubleSliceSum {

    /*
     * N is an integer within the range [3..100,000];
     * each element of array A is an integer within the range [−10,000..10,000].
     */
    public int solution(int[] A) {
        int[] prevSubSum = new int[A.length];
        int[] postSubSum = new int[A.length];

        for (int i = 1; i < A.length - 1; i++) {
            prevSubSum[i] = Math.max(0, prevSubSum[i - 1] + A[i]);
        }
        for (int i = A.length - 2; i > 0; i--) {
            postSubSum[i] = Math.max(0, postSubSum[i + 1] + A[i]);
        }
        int globalMaxSum = 0;
        for (int i = 1; i < A.length - 1; i++) {
            globalMaxSum = Math.max(prevSubSum[i - 1] + postSubSum[i + 1], globalMaxSum);
        }
        return globalMaxSum;
    }
}
