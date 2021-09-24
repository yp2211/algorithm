package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

/*
 https://app.codility.com/demo/results/trainingXP8FCZ-Z7F/
 */
public class PeaksIntuitive {
    public int solution(int[] A) {
        int result = 0;
        int N = A.length;

        for (int K = 2; K <= N; K++) {
            int blocks = (int)Math.ceil(N/K);
            if (blocks > result) {
                if (checkK(A, K)) result = blocks;
            } else {
                break;
            }
        }

        return result;
    }

    private boolean checkK(int[] A, int K) {
        for (int slice = 0; slice * K < A.length; slice++) {
            if (!hasPeakInSubArray(A, slice * K, Math.min(A.length - 1, (slice * K + K - 1)))) return false;
        }
        return true;
    }

    private boolean hasPeakInSubArray(int[] A, int start, int end) {
        for (int i = start; i <= end && i < A.length - 1; i++) {
            if (i == 0) continue;
            if (A[i] > A[i-1] && A[i] > A[i+1]) return true;
        }
        return false;
    }
}
