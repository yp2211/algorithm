package codility.lessons.Lesson2_Arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by peng.yang on ${Date}
 */
public class OddOccurrencesInArray {
    public int solution(int[] A) {
        int goal = 0;

        HashMap hashMap = new HashMap();
        ArrayList array = new ArrayList();
        for (int aA : A) {
            if (hashMap.containsKey(aA)) {

            }

        }

        ArrayList<Integer> arrayB = new ArrayList<>();


        boolean[] B = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            int currentNumber = A[i];
            boolean isOddNumber = true;
            for (int aA : A) {
                if (aA == currentNumber) {
                    isOddNumber = !isOddNumber;
                }
            }
            B[i] = isOddNumber;
        }
        for (int k = 0; k < B.length; k++) {
            if (B[k]) goal = A[k];
        }

        return goal;
    }
}
