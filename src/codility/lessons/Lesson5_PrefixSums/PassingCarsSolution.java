package codility.lessons.Lesson5_PrefixSums;

/**
 * Created by peng.yang on ${Date}
 */
public class PassingCarsSolution extends AbstractPassingCars {
    @Override
    public int solution(int[] A) {
        int goal = 0;
        int[] P = new int[A.length + 1];
        P[0] = 0;
        for (int i = 0; i < A.length; i++) {
            P[i + 1] = P[i] + A[i];
        }

        for (int j = 0; j < A.length - 1; j++) {
            if (A[j] == 0) {
                goal += P[P.length - 1] - P[j + 1];
                if (goal > 1000000000) {
                    return -1;
                }
            }
        }

        return goal;
    }
}
