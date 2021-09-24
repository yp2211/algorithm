package codility.lessons.Lesson10_PrimeAndCompositeNumbers;

public class CountFactors {
    public int solution(int N){
        long i = 1;
        int result = 0;
        while (i * i < N) {
            if (N % i == 0)
                result += 2;
            i++;
        }
        if (i * i == N) result += 1;

        return result;
    }
}
