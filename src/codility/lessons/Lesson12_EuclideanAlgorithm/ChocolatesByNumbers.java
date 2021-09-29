package codility.lessons.Lesson12_EuclideanAlgorithm;

public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        return N / gcdBinary(N, M, 1);
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
