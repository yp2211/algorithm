package codility.lessons.Lesson11_SieveOfEratosthenes;

import java.util.ArrayList;

public class Exercises {
    /*
    O(n log log n)
     */
    public boolean[] sieve(int N) {
        boolean[] result = new boolean[N + 1];
        java.util.Arrays.fill(result, true);

        result[0] = false;
        result[1] = false;
        int i = 2;
        while (i * i <= N) {
            if (result[i]) {
                int K = i * i;
                while (K <= N) {
                    result[K] = false;
                    K += i;
                }
            }
            i += 1;
        }

        return result;
    }

    public int[] factorization(int N) {
        int[] F = new int[N+1];
        int i = 2;
        while (i * i <= N) {
            if (F[i] == 0) {
                int K = i * i;
                while (K <= N) {
                    if (F[K] == 0) {
                        F[K] = i;
                    }
                    K += i;
                }
            }
            i += 1;
        }
        return F;
    }

    public int[] factorizationX(int x, int[] F) {
        java.util.ArrayList<Integer> primeFactors = new ArrayList<>();
        while(F[x] > 0) {
            primeFactors.add(F[x]);
            x /= F[x];
        }
        primeFactors.add(x);
        return primeFactors.stream().mapToInt(i -> i).toArray();
    }
}
