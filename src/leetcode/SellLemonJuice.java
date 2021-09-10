package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SellLemonJuice {
    public static void main(String[] args) {
        int[] A = new int[] {5, 5, 5, 5, 10, 20, 10};
        int[] B = new int[] {5, 5, 20, 5};
        System.out.println(sellLemonJuice(A));
        System.out.println(sellLemonJuice(B));
    }

    private static boolean sellLemonJuice(int[] bills) {
        final int BILLS_5 = 5;
        final int BILLS_10 = 10;
        int having5 = 0;
        int having10 = 0;
        for (int bill : bills) {
            if (bill == BILLS_5) {
                having5++;
            } else if (bill == BILLS_10) {
                if (having5 == 0) {
                    return false;
                } else {
                    having5--;
                    having10++;
                }
            } else {
                if (having10 > 0 && having5 > 0) {
                    having10--;
                    having5--;
                } else if (having10 == 0 && having5 >= 3) {
                    having5 -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
