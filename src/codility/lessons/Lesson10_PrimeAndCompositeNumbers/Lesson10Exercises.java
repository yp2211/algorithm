package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

public class Lesson10Exercises {
    public int CountingDivisors(int N) {
        int i = 1;
        int result = 0;
        while (i * i < N) {
            if (N % i == 0)
                result += 2;
            i++;
        }
        if (i * i == N) result += 1;

        return result;
    }

    public boolean PrimalityTest(int N) {
        int i = 2;
        while (i * i <= N) {
            if (N % i == 0) return false;
            i++;
        }
        return true;
    }

}
