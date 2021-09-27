_Lesson11_
## [Sieve of Eratosthenes](https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/)

***
[Open reading material (PDF)](https://codility.com/media/train/9-Sieve.pdf)

> _Easy_
> ### [CountNonDivisible](https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/)
> Calculate the number of elements of an array that are not divisors of each element.

#### Task description
***
You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6

For the following elements:

* A[0] = 3, the non-divisors are: 2, 6,
* A[1] = 1, the non-divisors are: 3, 2, 3, 6,
* A[2] = 2, the non-divisors are: 3, 3, 6,
* A[3] = 3, the non-divisors are: 2, 6,
* A[4] = 6, there aren't any non-divisors.

Write a function:
```java
class Solution { public int[] solution(int[] A); }
```
that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6

the function should return [2, 4, 3, 2, 0], as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..50,000];
* each element of array A is an integer within the range [1..2 * N].

***

### Code Walkthrough
#### Code Intuitive
```java
class Solution {
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
```

**Conclusion**

* Detected time complexity: O(n<sup>2</sup>)
* Detected space complexity: O(N)

[Codility Report](https://app.codility.com/demo/results/trainingX4D9SU-8XP/)

|Task Score|Correctness|Performance|
|---|---|---|
|55%|100%|0%|


#### Code Optimized

```java
class Solution {
    public int[] solution(int[] A) {
        // [elements][divisors]
        int[][] bucket = new int[A.length * 2 + 1][2];

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
```

**Conclusion**
* Detected time complexity:  O(N * log(N))
* Detected space complexity: O(N)

[Codility Report](https://app.codility.com/demo/results/trainingZKFZ87-KQ9/)

***
