package codility.lessons.Lesson11_SieveOfEratosthenes;

public class CountNonDivisibleIntuitive {
    public int[] solution(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] % A[j] != 0) {
                    B[i] += 1;
                }
                if (A[j] % A[i] != 0) {
                    B[j] += 1;
                }
            }
        }
        return B;
    }
}
