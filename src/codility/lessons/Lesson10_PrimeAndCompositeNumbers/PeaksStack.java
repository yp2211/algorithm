package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

public class PeaksStack {
    public int solution(int[] A) {
        int result = 0;
        int N = A.length;

        java.util.ArrayList<Integer> peaks = new java.util.ArrayList<>();
        for (int i = 1; i < N - 1; i++)
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) peaks.add(i);

        if (peaks.size() <= 1) return peaks.size();

        int K = 1;      // elements number of one block
        int blocks;
        java.util.Stack<Integer> divisors = new java.util.Stack<>();
        // E.G. N = 12, K=[1,2,3]
        while (K * K <= N) {
            if (N % K == 0) {
                if (K * K == N) {
                    blocks = K;
                } else {
                    divisors.push(K);
                    blocks = N / K;
                }
                if (isOK(peaks, blocks, K)) return blocks;
            }
            K += 1;
        }

        while (!divisors.isEmpty()) {
            // E.G. N = 12, K=[1,2,3]
            //      blocks=[3,2,1] -> K=[4,6,12]
            blocks = divisors.pop();
            if (isOK(peaks, blocks, N / blocks)) return blocks;
        }

        return result;
    }

    private boolean isOK(java.util.ArrayList<Integer> peaks, int blocks, int k) {
        int currentBucket = 0;
        for (Integer peak : peaks) {
            int peakBucket = peak / k;
            if (peakBucket == currentBucket) {
                // current bucket is filled, then go to next bucket
                currentBucket += 1;
                // until last bucket is filled
                if (currentBucket == blocks) break;
            } else if (peakBucket > currentBucket) {
                currentBucket = -1;
                break;
            }
        }
        return currentBucket == blocks;
    }
}