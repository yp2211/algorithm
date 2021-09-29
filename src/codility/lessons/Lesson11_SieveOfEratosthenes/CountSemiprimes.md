_Lesson11_
## [Sieve of Eratosthenes](https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/)

***
[Open reading material (PDF)](https://codility.com/media/train/9-Sieve.pdf)

> _Medium_
> ### [CountSemiprimes](https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/)
> Count the semiprime numbers in the given range [a..b]

#### Task description
***
A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

The number of semiprimes within each of these ranges is as follows:

* (1, 26) is 10,
* (4, 10) is 4,
* (16, 20) is 0.

Write a function:
```java
class Solution { public int[] solution(int N, int[] P, int[] Q); }
```
that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..50,000];
* M is an integer within the range [1..30,000];
* each element of arrays P, Q is an integer within the range [1..N];
* P[i] ≤ Q[i].

***

### Code Walkthrough

#### Code Intuitive
```java
class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
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

        int M = P.length;
        int[] isSemiprime = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int start = P[i], end = Q[i];
            P[i] = 0;
            for (int j = start; j <= end; j++) {
                if (isSemiprime[j] == 0){       // has not been checked
                    isSemiprime[j] = -1;        // mark checked
                    // whether j is semiprime
                    if (F[j] > 0) {             // not prime, value of F[j] is the first prime divisor of number j
                        int x = j / F[j];
                        if (F[j / F[j]] == 0) {    // the second divisor is prime
                            isSemiprime[j] = 1; // mark semiprime
                        }
                    }
                }
                P[i] += isSemiprime[j] > 0 ? 1 : 0;
            }
        }

        return P;
    }
}
```

**Conclusion**
* Detected time complexity: O(N * log(log(N)) + M * N) or O(M * N ** (3/2))
* Detected space complexity: O(N)

[Codility Report](https://app.codility.com/demo/results/training7UKEAN-SSD/)

|Task Score|Correctness|Performance|
|---|---|---|
|66%|100%|40%|

#### Code Optimized
We can use a simple yet powerful technique "prefix sums" that allows for the fast calculation of sums of elements in given slice. 

> [Lesson 5 Prefix Sums](https://app.codility.com/programmers/lessons/5-prefix_sums/)  
> [Open reading material (PDF)](https://codility.com/media/train/3-PrefixSums.pdf)

**optimized code:**  
```java
class Solution {
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
```

**Conclusion**
* Detected time complexity:  O(N * log(log(N)) + M)
* Detected space complexity: O(N)

[Codility Report](https://app.codility.com/demo/results/trainingAWV5GB-M73/)

|Task Score|Correctness|Performance|
|---|---|---|
|100%|100%|100%|
***
