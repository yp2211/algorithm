package codility.lessons.Lesson9_MaximumSliceProblem;

public class MaxSliceSumKadane {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;

        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int a : A) {
            localMax = Math.max(a + localMax, a);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}
