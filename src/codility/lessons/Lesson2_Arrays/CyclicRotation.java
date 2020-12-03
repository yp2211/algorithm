package codility.lessons.Lesson2_Arrays;

import java.util.ArrayList;

/**
 * Created by peng.yang on ${Date}
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int N = A.length;
        int[] B = new int[N];

        if (N > 0 && K > 0) {
            ArrayList<Integer> arrayB = new ArrayList<>();

            for (int aA : A) {
                arrayB.add(aA);
            }

            for (int j = 0; j < K; j++) {
                arrayB.add(0, arrayB.get(arrayB.size() - 1));
                arrayB.remove(arrayB.size() - 1);
            }

            for (int k = 0; k < arrayB.size(); k++) {
                B[k] = arrayB.get(k);
            }
        } else {
            B = A;
        }

        return B;
    }
}
