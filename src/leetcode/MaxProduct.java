package leetcode;

public class MaxProduct {
    public static void main(String[] args) {
        int[] A = new int[] {-999, 1,2,3,4,5,6};
        int[] B = new int[] {-999,-998, -997, 1,2,3,4,5,6};
        int[] C = new int[] {-999,-998, -997, -1,-2,-3,-4,-5,-6};
        int[] D = new int[] {-999,-998, -997, -1,-2,-3,-4,-5, 6};
        System.out.println(sort(new int[]{1,2,3,4,5,6}));
        System.out.println(getMaxMin(new int[]{1,2,3,4,5,6}));

        System.out.println(sort(A));
        System.out.println(getMaxMin(A));

        System.out.println(sort(B));
        System.out.println(getMaxMin(B));

        System.out.println(sort(C));
        System.out.println(getMaxMin(C));

        System.out.println(sort(D));
        System.out.println(getMaxMin(D));
        System.out.println(-999*-998*6);
    }

    static int sort(int[] numbs) {
        java.util.Arrays.sort(numbs);
        int n = numbs.length;
        return Math.max(
                numbs[0] * numbs[1] * numbs[n-1],
                numbs[n-1]*numbs[n-2]*numbs[n-3]
        );
    }

    static int getMaxMin(int[] numbs) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : numbs) {
            if ( x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if ( x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(
                min1 * min2 * max1,
                max1 * max2 * max3
        );
    }
}
