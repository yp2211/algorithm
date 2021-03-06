package codility.lessons.Lesson1_Iterations.Solutions;

import codility.lessons.Lesson1_Iterations.IBinaryGap;

/**
 * Created by peng.yang on ${Date}
 */
public class BinaryGapSolution implements IBinaryGap {

    @Override
    public int solution(int N) {
        int goal = 0;

        String binaryN = Integer.toBinaryString(N);
        char[] charsBinaryN = binaryN.toCharArray();

        int counter = 0;
        boolean counterSwitch = false;
        for (char aCharsBinaryN : charsBinaryN) {
            if (aCharsBinaryN == '0') {
                counterSwitch = true;
                counter++;
            } else if (aCharsBinaryN == '1') {
                if (counterSwitch) {
                    counterSwitch = false;
                    if (counter > goal) {
                        goal = counter;
                    }
                    counter = 0;
                }
            }
        }

        return goal;
    }
}
