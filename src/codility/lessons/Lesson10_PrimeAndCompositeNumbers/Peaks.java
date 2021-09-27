package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

public class Peaks {
    public int solution(int[] A) {
//        int result = 0;
        int N = A.length;

        java.util.ArrayList<Integer> peaks = new java.util.ArrayList<>();
        for (int i = 1; i < N - 1; i++)
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) peaks.add(i);

        if (peaks.size() <= 1) return peaks.size();

        for (int K = 1; K <= N; K++) {                  // K: block size
            if (N % K == 0) {
                int blocks = N / K;
                int currentBucket = 0;
                for (Integer peak : peaks) {
                    int peakBucket = peak / K;
                    if (peakBucket == currentBucket) {
                        // current bucket has been filled, then go to next bucket
                        currentBucket += 1;
                        // until last bucket is filled
                        if (currentBucket == blocks) break;
                    } else if (peakBucket > currentBucket) {
                        currentBucket = -1;
                        break;
                    }
                }

                if (currentBucket == blocks) return blocks;
            }
        }
        return 0;
//        int blocks = 1;
//        int K = N;      // length of one block
//        java.util.Stack<Integer> divisors = new java.util.Stack<>();
//        while (blocks * blocks <= N) {
//            if (N % blocks == 0) {
//                divisors.push(blocks);
//                K = N / blocks;
//
//                result = getResult(result, peaks, blocks, K);
//            }
//            blocks += 1;
//        }
//
//        while (!divisors.isEmpty()) {
//            K = divisors.pop();
//            if (K == 1) continue;
//            result = getResult(result, peaks, N / K, K);
//        }

//        return result;
    }

//    private int getResult(int result, java.util.ArrayList<Integer> peaks, int blocks, int k) {
//        int currentBucket = 0;
//        for (Integer peak : peaks) {
//            int peakBucket = peak / k;
//            if (peakBucket == currentBucket) {
//                // current bucket is filled, then go to next bucket
//                currentBucket += 1;
//                // until last bucket is filled
//                if (currentBucket == blocks) break;
//            } else if (peakBucket > currentBucket) {
//                currentBucket = -1;
//                break;
//            }
//        }
//
//        if (currentBucket == blocks) result = Math.max(result, blocks);
//        return result;
//    }
}