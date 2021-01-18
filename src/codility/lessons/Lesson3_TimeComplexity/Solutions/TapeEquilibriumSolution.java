package codility.lessons.Lesson3_TimeComplexity.Solutions;

import codility.lessons.Lesson3_TimeComplexity.ITapeEquilibrium;

/**
 * Created by peng.yang on ${Date}
 */
public class TapeEquilibriumSolution implements ITapeEquilibrium {
    @Override
    public int solution(int[] A) {
        int difference = 0;
        int sumPart1 = 0;
        int sumPart2 = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        sumPart1 = A[0];
        sumPart2 = sum - sumPart1;
        difference = Math.abs(sumPart1 - sumPart2);
        for (int p = 2; p < A.length; p++) {
            sumPart1 += A[p - 1];
            sumPart2 -= A[p - 1];
            int temp = Math.abs(sumPart1 - sumPart2);
            if (temp < difference) {
                difference = temp;
            }
        }

        return difference;
    }
}
