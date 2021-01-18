package codility.lessons.Lesson2_Arrays.Solutions;

import codility.lessons.Lesson2_Arrays.IOddOccurrencesInArray;

import java.util.ArrayList;

/**
 * Created by peng.yang on ${Date}
 */
public class OddOccurrencesInArraySolution implements IOddOccurrencesInArray {

    // [Candidate Report: training66EE8T-EUB](https://app.codility.com/demo/results/training66EE8T-EUB/)
    public int solution(int[] A) {
        int goal = 0;

        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length -1; i++) {
            if (A[i] != A[i + 1]) {
                goal = A[i];
                break;
            }
            i++;
        }

        if (goal == 0) {
            goal =  A[A.length - 1];
        }

        return goal;
    }

    // [Candidate Report: trainingP37TDW-Y2G](https://app.codility.com/demo/results/trainingP37TDW-Y2G/)
    public int trainingP37TDW_Y2G(int[] A) {
        int goal = 0;

        int bias, min = A[0], max = A[0];
        for (int anA : A) {
            if (anA > max)
                max = anA;
            if (anA < min)
                min = anA;
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];

        for (int anA : A) {
            bucket[anA + bias]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if ((bucket[i] % 2) > 0) {
                goal = i - bias;
                break;
            }
        }

        return goal;
    }

    // [Candidate Report: trainingZ5Q4VB-3YD](https://app.codility.com/demo/results/trainingZ5Q4VB-3YD/)
    public int trainingZ5Q4VB_3YD(int[] A) {
        int goal = 0;

        ArrayList<Integer> array = new ArrayList();
        for (int aA : A) {
            int index = array.indexOf(aA);
            if (index < 0) {
                array.add(aA);
            } else {
                array.remove(index);
            }
        }
        if (array.size() > 0) {
            goal = array.get(0);
        }

        return goal;
    }
}
