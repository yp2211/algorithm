package codility.demo;

public class Demo {
    public static int solution(int[] A) {
        // write your code in Java SE 11
        final int MAX_COUNT = 1000000;

        int rtn = 1;
        byte[] numbers = new byte[MAX_COUNT + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) numbers[A[i]] = 1;
        }
        for (int j = 1; j < numbers.length; j++) {
            if (0 == numbers[j]) {
                rtn = j;
                break;
            }
        }

        return rtn;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 3, 6, 4, 1, 2};
        int[] B = new int[] {1, 2, 3};
        int[] C = new int[] {-1, -3};
        System.out.println(solution(A));
        System.out.println(solution(B));
        System.out.println(solution(C));
    }
}
