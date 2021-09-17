package codility.lessons.Lesson9_MaximumSliceProblem;

public class MaxSliceSum {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;

        int P = 0, S = A[0], S1 = A[0];
        for (int Q = 1; Q < A.length; Q++) {
            if (A[Q] < 0 && S1 + A[Q] < 0) {
                P = Q;
                S1 = A[Q];
            } else {
                S1 += A[Q];
                for (int i = P; i < Q; i++) {
                    if (A[i] < 0 || (P + 1 < Q && A[P] + A[P + 1] < 0)) {
                        P = i + 1;
                        S1 -= A[i];
                    } else {
                        break;
                    }
                }
            }

            if (S1 > S) S = S1;
        }
        return S;
    }
}
