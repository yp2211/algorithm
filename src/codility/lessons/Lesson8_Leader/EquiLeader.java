package codility.lessons.Lesson8_Leader;

public class EquiLeader {
    public int solution(int[] A) {
        if (A == null || A.length <= 1) return 0;

        java.util.HashMap<Integer, Integer> counter = new java.util.HashMap<>();

        int dominatorCount = A.length / 2;
        int leader = -1;
        for (int i = 0; i < A.length; i++) {
            int aCount = 1;
            if (counter.containsKey(A[i])) {
                aCount += counter.get(A[i]);
            }

            if (aCount > dominatorCount) {
                leader = A[i];
            }
            counter.put(A[i], aCount);
        }
        if (!counter.containsKey(leader)) return 0;

        int leaderTotal = counter.get(leader);

        int S = 0;
        int leaderCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                leaderCounter += 1;
            }

            int preLeaderNum =  (i + 1) / 2;                        // 1 ~ S (0 ~ i)
            int postLeaderNum = (A.length - i - 1) / 2;             // S+1 ~ N (i+1 ~ length-1)
            if (leaderCounter > preLeaderNum && (leaderTotal - leaderCounter) > postLeaderNum) {
                S += 1;
            }
        }
        return S;
    }
}
