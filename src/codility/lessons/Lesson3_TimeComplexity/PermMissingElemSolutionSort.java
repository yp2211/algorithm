package codility.lessons.Lesson3_TimeComplexity;

/**
 * Created by peng.yang on ${Date}
 */
public class PermMissingElemSolutionSort extends AbstractPermMissingElem {
    @Override
    public int solution(int[] A) {
        if (A.length == 0) return 1;

        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if ((i + 1) != A[i]) return i + 1;
        }
        return A.length + 1;
    }
}
