package codility.challenges.TheOLXGroupchallenge.Solutions;

import codility.challenges.TheOLXGroupchallenge.IMultivitamin;

/**
 * Created by peng.yang on ${Date}
 */
public class MultivitaminSolution implements IMultivitamin {
    @Override
    public int solution(int[] juice, int[] capacity) {
        int goal = 1;

        // 1. sort: O(N*N)
        int current;
        int currentCapacity;
        for (int i = 0; i < juice.length - 1; i++) {
            current = juice[i + 1];
            currentCapacity = capacity[i + 1];

            int preIndex = i;
            while (preIndex >= 0 && current < juice[preIndex]) {
                juice[preIndex + 1] = juice[preIndex];
                capacity[preIndex + 1] = capacity[preIndex];
                preIndex--;
            }
            juice[preIndex + 1] = current;
            capacity[preIndex + 1] = currentCapacity;
        }

        //Prefix sums: O(N)
        int[] P = new int[juice.length + 1];
//        int[] L = new int[juice.length];
//        int maxLeft = 0;
//        int maxLeftIndex = 0;
        for (int i = 1; i < P.length; i++) {
            P[i] = P[ i - 1 ] + juice[ i - 1 ];
//            L[i - 1] = capacity[i - 1] - juice[i - 1];
//            if (L[i - 1] >= maxLeft) {
//                maxLeftIndex = i - 1;
//                maxLeft = L[maxLeftIndex];
//            }
        }

        // 2. mix: O(N + m)
        int tempCounter;
        for (int j = 0; j < juice.length; j++) {
            tempCounter = 0;
            for (int k = goal; k < P.length; k++) {
                // P[k] = juice[k - 1] + ....juice[0]
                int mixedCapacity = P[k];
                tempCounter = k;
                if (k <= j) {
                    mixedCapacity +=juice[j];
                    tempCounter += 1;
                }

                if (mixedCapacity <= capacity[j]) {
                    goal = tempCounter;
                }
            }
        }

        return goal;
    }
}
