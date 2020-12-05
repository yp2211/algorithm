package codility.lessons.Lesson4_CountingElements;

/**
 * Created by peng.yang on ${Date}
 */
public class PermCheckSolution extends AbstractPermCheck {
    @Override
    public int solution(int[] A) {
        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i + 1) continue;
            else return 0;
        }

        return 1;
    }
}
