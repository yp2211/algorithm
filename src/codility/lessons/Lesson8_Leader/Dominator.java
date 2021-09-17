package codility.lessons.Lesson8_Leader;

public class Dominator {
    public int solution(int[] A) {
        java.util.HashMap<Integer, Integer> counter = new java.util.HashMap<>();

        int dominatorCount = A.length / 2;
        for (int i = 0; i < A.length; i++) {
            int aCount = 0;
            if (counter.containsKey(A[i])) {
                aCount = counter.get(A[i]) + 1;
            } else {
                aCount = 1;
            }

            if (aCount > dominatorCount) {
                return i;
            } else {
                counter.put(A[i], aCount);
            }
        }
        return -1;
    }
}
