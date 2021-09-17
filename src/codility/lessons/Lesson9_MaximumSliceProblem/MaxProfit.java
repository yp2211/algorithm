package codility.lessons.Lesson9_MaximumSliceProblem;

public class MaxProfit {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;

        int k = 0, m = 0, p = 0;
        int k1 = 0;
        for (int i = 1; i < A.length; i++) {
            if (k1 > k) {
                if (A[i] < A[k1]) {
                    k1 = i;
                } else if (A[i] - A[k1] >= p) {
                    k = k1;
                    m = i;
                    p = A[i] - A[k];
                }
            } else {
                if (A[i] >= A[m]) {
                    m = i;
                    p = A[m] - A[k];
                } else if (A[i] < A[k]) {
                    k1 = i;
                } // else // A[k] <= A[i] < A[m]  do nothing
            }
        }

        return p;
    }
}
