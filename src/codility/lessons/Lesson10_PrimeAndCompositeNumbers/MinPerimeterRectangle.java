package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

public class MinPerimeterRectangle {
    public int solution(int N) {
        int i = 1;
        int minPerimeter  = Integer.MAX_VALUE;
        while (i * i <= N) {
            if (N % i == 0) {
                int A = i;
                int B = N / i;
                minPerimeter = Math.min(minPerimeter, 2 * (A + B));
            }
            i++;
        }

        return minPerimeter;
    }
}
