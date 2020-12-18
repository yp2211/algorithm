package codility.lessons.Lesson1_Iterations;

/**
 * Created by peng.yang on ${Date}
 */
public class BinaryGapShifter {

    public static int solution(int N) {
        int goal = 0;
        int counter = 0;
        boolean counterSwitch = false;
        while (N > 0) {
            if ((N & 1) == 1) {
                if (counterSwitch) {
                    if (counter > goal) goal = counter;

                    counter = 0;
                } else {
                    counterSwitch = true;
                }
            } else {
                if (counterSwitch) counter++;
            }

            N = N >> 1;
        }

        return goal;
    }
}
