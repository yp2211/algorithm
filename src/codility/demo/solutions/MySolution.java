package codility.demo.solutions;

import codility.demo.IGetSmallestPositiveInteger;

import java.util.Arrays;

public class MySolution implements IGetSmallestPositiveInteger {
    @Override
    public int solution(int[] A) {
        // A.length --> N[1..100,000]
        // A[i] --> [−1,000,000..1,000,000]
        // {1, 3, 6, 4, 1, 2} --> 5
        // final int MIN_RESULT = 1;
        // MAX_RESULT = max(A[i])+1;
        int aPoint = 0;

        Arrays.sort(A); // Time: O(logN)   Space: O(1);

        // Time: O(n)   Space: O(1);
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0 || A[i] == aPoint) {
                continue;
            }

            if (A[i] == aPoint + 1) {
                aPoint = A[i];
            } else {
                break;
            }

        }

        return aPoint + 1;
    }
}
