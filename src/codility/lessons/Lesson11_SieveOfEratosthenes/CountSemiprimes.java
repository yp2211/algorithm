package codility.lessons.Lesson11_SieveOfEratosthenes;

import java.util.Arrays;

public class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int M = Q.length;
        int[] F = new int[N+1];
        int f = 2;
        while (f * f <= N) {
            if (F[f] == 0) {
                int K = f * f;
                while (K <= N) {
                    if (F[K] == 0) {
                        F[K] = f;
                    }
                    K += f;
                }
            }
            f += 1;
        }

        int[] isSemiprime = new int[N + 1];
        for (int s = 4; s <= N; s++) {
            // whether j is semiprime
            if (F[s] > 0) {                 // not prime, value of F[j] is the first prime divisor of number j
                int x = s / F[s];
                if (F[s / F[s]] == 0) {     // the second divisor is prime
                    isSemiprime[s] = 1;     // mark semiprime
                }
            }
        }

        int[] prefixSums = new int[N + 1];
        for (int p = 1; p < N+1; p++) {
            prefixSums[p] = prefixSums[p - 1] + isSemiprime[p];
        }

        for (int i = 0; i < M; i++) {
            P[i] = prefixSums[Q[i]] - prefixSums[P[i] - 1];
        }
        return P;
    }
}
