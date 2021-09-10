package leetcode;

public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
        System.out.println(halfSearch(10));
        System.out.println(newton(10));
    }

    static int arrangeCoins(int N) {
        int result = 0;
//        int arrangedCoins = 0;
//        int leftCoins = N;
        for (int i = 1; i <= N; i++) {
            N = N - i;
            if (N <= i) {
                result = i;
                break;
            }
        }
        return result;
    }

    static int halfSearch(int N) {
        int low = 0;
        int high = N;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int arrangedCoins = mid*(mid+1)/2; // sum(1, 2, 3,...,i) = i(i+1)/2
            if (arrangedCoins == N) {
                return mid;
            } else if (arrangedCoins > N) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    static int newton(int N) {
        if (N == 0) return 0;

        return (int)sqrt(N, N);
    }

    /*
     * sum(1, 2, 3,...,X) = X(X+1)/2
     * N >= X(X+1)/2
     * 2N >= X*X + X
     * sqrt(2N - X) >= X
     * --> find out sqrt(2N - X)
     */
    static double sqrt(double x, int n) {
        double res = (x + (2*n - x)/x)/2;
        if (res == x) {
            return x;
        } else {
            return sqrt(res, n);
        }
    }
}
