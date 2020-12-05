package codility.lessons.Lesson4_CountingElements;

/**
 * Created by peng.yang on ${Date}
 */
public class MaxCountersSlow77 extends AbstractMaxCounters {
    @Override
    public int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int maximumValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                //increase
                B[A[i] - 1] += 1;
                if (B[A[i] - 1] > maximumValue) {
                    maximumValue = B[A[i] - 1];
                }
            } else if (A[i] >= N + 1) {
                //max counter
                java.util.Arrays.fill(B, maximumValue);
            }
        }

        return B;
    }
}
