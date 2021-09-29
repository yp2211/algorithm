package codility.lessons.Lesson12_EuclideanAlgorithm;

public class Lesson12Exercises {
    private int counter = 0;
    public int gcdSubtraction(int a, int b) {
        counter+=1;
        if (a == b) System.out.println(counter);
        if (a == b) return a;
        if (a > b) return gcdSubtraction(a - b, b);
        else return gcdSubtraction(a, b - a);
    }

    public int gcdDivision(int a, int b) {
        counter+=1;
        if (a % b == 0) System.out.println(counter);

        if (a % b == 0) return b;
        else return gcdDivision(b, a % b);
    }

    public int gcdBinary(int a, int b, int res) {
        counter+=1;
        if (a == b) System.out.println(counter);
        if (a == b) return res * a;
        else if (a % 2 == 0 && b % 2 == 0) return gcdBinary(a >> 1, b >> 1, 2 * res);
        else if (a % 2 == 0) return gcdBinary(a >> 1, b, res);
        else if (b % 2 == 0) return gcdBinary(a, b >> 1, res);
        else if (a > b) return gcdBinary(a - b, b, res);
        else return gcdBinary(a, b - a, res);
    }
}
