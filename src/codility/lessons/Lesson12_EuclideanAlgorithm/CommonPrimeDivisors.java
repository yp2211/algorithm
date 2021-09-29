package codility.lessons.Lesson12_EuclideanAlgorithm;

public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                result +=1;
                continue;
            }
            if (compute(A[i], B[i]) && compute(B[i], A[i])) result += 1;
        }

        return result;
    }
    private boolean compute(int a, int b) {
        if (b%a == 0) return true;
        int gcd = gcdBinary(a, b, 1);
        if (gcd == 1) return false;
        return compute(a/gcd, b);
    }

    private int gcdBinary(int a, int b, int res) {
        if (a == b) return res * a;
        else if (a % 2 == 0 && b % 2 == 0) return gcdBinary(a >> 1, b >> 1, 2 * res);
        else if (a % 2 == 0) return gcdBinary(a >> 1, b, res);
        else if (b % 2 == 0) return gcdBinary(a, b >> 1, res);
        else if (a > b) return gcdBinary(a - b, b, res);
        else return gcdBinary(a, b - a, res);
    }
}
