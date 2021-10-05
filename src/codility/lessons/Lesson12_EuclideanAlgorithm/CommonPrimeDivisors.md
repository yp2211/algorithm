_Lesson 12_
## [Euclidean algorithm](https://app.codility.com/programmers/lessons/12-euclidean_algorithm/)

***
[Open reading material (PDF)](https://codility.com/media/train/10-Gcd.pdf)

> _Medium_
> ### [CommonPrimeDivisors](https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/)
> Check whether two numbers have the same prime divisors.

***

#### Task description
A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.

You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

For example, given:

* N = 15 and M = 75, the prime divisors are the same: {3, 5};
* N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
* N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.

Write a function:

```java
class Solution { public int solution(int[] A, int[] B); }
```

that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

For example, given:

    A[0] = 15   B[0] = 75
    A[1] = 10   B[1] = 30
    A[2] = 3    B[2] = 5

the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

Write an efficient algorithm for the following assumptions:

* Z is an integer within the range [1..6,000];
* each element of arrays A, B is an integer within the range [1..2,147,483,647].

***

#### Code Walkthrough
If integer A[i] and B[i] has the same set of prime divisors, A[i] repeatedly divided by the prime divisors of B[i], we can get 1 at last (the remainder is 0). And also B[i] repeatedly divided by the prime divisors of A[i], we can get 1 (the remainder is 0) at last too.

GCD (greatest common divisor) of A[i] and B[i] is a multiple of prime divisors, so we can use gcd to simplify calculations .

For example, given:

    A[i] = 270  B[i] = 60

    For A[i] must meet condition like:
      270    60            -> 270%60 != 0 -> 
      gcd(270, 60) = 30    -> 60/30=2     ->
              2            -> 270%2  == 0 -> OK

    For B[i] must meet condition like:
      60    270            -> 60%270 != 0 -> 
      gcd(60, 270) = 30    -> 270/30 == 9 ->
              9            -> 60%9 != 0   ->
      gcd(60, 9) = 3       -> 9/3 == 3    ->
              3            -> 60%3 == 0   -> OK

```java
class Solution {
    public int solution(int[] A, int[] B) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                result +=1;
                continue;
            }
            if (compute(A[i], B[i]) && compute(B[i], A[i])) result += 1;
        }

        return result;
    }
    private boolean compute(int a, int b) {
        if (b%a == 0) return true;
        int gcd = gcdBinary(a, b, 1);
        if (gcd == 1) return false;
        return compute(a/gcd, b);
    }

    private int gcdBinary(int a, int b, int res) {
        if (a == b) return res * a;
        else if (a % 2 == 0 && b % 2 == 0) return gcdBinary(a >> 1, b >> 1, 2 * res);
        else if (a % 2 == 0) return gcdBinary(a >> 1, b, res);
        else if (b % 2 == 0) return gcdBinary(a, b >> 1, res);
        else if (a > b) return gcdBinary(a - b, b, res);
        else return gcdBinary(a, b - a, res);
    }
}
```

#### Conclusion
* Detected time complexity: O(Z * log(max(A) + max(B))<sup>2</sup>)
* Detected space complexity: O(1)

[Codility Report](https://app.codility.com/demo/results/training7EU7VN-3PB/)

***
