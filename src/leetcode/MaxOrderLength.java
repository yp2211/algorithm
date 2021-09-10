package leetcode;

public class MaxOrderLength {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,2,3,4,3,4,5,6,7};
        int[] B = new int[] {1,2,3,2,3,4,3,4,5,5,7};
        System.out.println(getMaxOrderLength(A));
        System.out.println(getMaxOrderLength(B));
    }

    private static int getMaxOrderLength(int[] numbs) {
        int startPoint = 0;
        int maxLength = 0;
        for (int i = 1; i < numbs.length; i++) {
            if (numbs[i] <= numbs[i - 1]) {
                startPoint = i;
            }
            maxLength = Math.max(maxLength, i - startPoint + 1);
        }

        return maxLength;
    }
}
