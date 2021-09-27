package codility.lessons.Lesson11_SieveOfEratosthenes;

public class CountNonDivisible {
    public int[] solution(int[] A) {
        // [elements][divisors]
        int[][] bucket = new int[A.length*2 + 1][2];

        // bucket sorting
        for (int a : A) {
            bucket[a][0]++;      // remember how many the number "A[i]" in A
            bucket[a][1] = -1;   // divisors initialized
        }

        for (int a : A) {
            if (bucket[a][1] == -1) {
                bucket[a][1] = 0;
                // get all divisors of the integer A[i]
                for (int j = 1; j * j <= a; j++) {
                    if (a % j == 0 && a / j != j) {
                        bucket[a][1] += bucket[j][0];       // Factorization: j
                        bucket[a][1] += bucket[a / j][0];  // Factorization: element/j
                    } else if (a % j == 0 && a / j == j) {
                        bucket[a][1] += bucket[j][0];
                    }
                }
            }
        }
        // using array A to set results for not arranging new space
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - bucket[A[i]][1];
        }
        return A;
    }
}
