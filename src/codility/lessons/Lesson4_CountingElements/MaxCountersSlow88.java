package codility.lessons.Lesson4_CountingElements;

/**
 * Created by peng.yang on ${Date}
 */
public class MaxCountersSlow88 extends AbstractMaxCounters {
    /*
     * Detected time complexity:
     *     O(N + M)
     */
    @Override
    public int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int currentMaximumValue = 0;
        int maximumValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                maximumValue += currentMaximumValue;
                B = new int[N];
                currentMaximumValue = 0;
            } else {
                B[A[i] - 1] += 1;
                if (B[A[i] - 1] > currentMaximumValue) currentMaximumValue = B[A[i] - 1];
            }
        }
        for (int j = 0; j < B.length; j++) {
            B[j] += maximumValue;
        }

        return B;
    }
}
