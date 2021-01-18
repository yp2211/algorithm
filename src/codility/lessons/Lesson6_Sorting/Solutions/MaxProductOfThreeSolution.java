package codility.lessons.Lesson6_Sorting.Solutions;

import codility.lessons.Lesson6_Sorting.IMaxProductOfThree;

/**
 * Created by peng.yang on ${Date}
 */
public class MaxProductOfThreeSolution implements IMaxProductOfThree {

    @Override
    public int solution(int[] A) {
        int max1 = -9999;
        int max2 = -9999;
        int max3 = -9999;
        int min2 = 9999;
        int min1 = 9999;

        for (int a : A) {
            if (a > max1) {
                max3 = max2;
                max2 = max1;
                max1 = a;
            } else if (a > max2) {
                max3 = max2;
                max2 = a;
            } else if (a > max3) {
                max3 = a;
            }

            if (a < min1) {
                min2 = min1;
                min1 = a;
            } else if (a < min2) {
                min2 = a;
            }
        }

        int maxProduct = max1 * max2 * max3;

        if (max1 <= 0 || min1 >= 0) {
            // 全て負 || 全て正
            return maxProduct;
        } else {
            if (min2 < 0 ) {
                // せめて2つ負
                int temp = max1 * min1 * min2;
                if (temp > maxProduct) return temp;
            }
        }

        return maxProduct;
    }
}
