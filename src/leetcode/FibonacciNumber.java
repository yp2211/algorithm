package leetcode;

public class FibonacciNumber {
    public static void main(String[] args) {
        // N[1, n]
        System.out.println(GetFibonacciNumberN(10));
    }

    static int GetFibonacciNumberN(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        // { 0, 1, 1, 2, 3, 5, 8, 13 ... }
        // i=0  1  2  3  4  5  6  7
        int numbN = 1;
        int numbPreN1 = 0;
        int numbPreN2 = 1;
        int i = 2;
        do {
            numbN = numbPreN1 + numbPreN2;
            System.out.println("N"+i+"="+numbN);
            numbPreN1 = numbPreN2;
            numbPreN2 = numbN;
            i++;
        } while (i <= N);
        return numbN;
    }
}
