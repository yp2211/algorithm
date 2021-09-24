_Lesson10_
## [Prime and composite numbers](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/)

***
[Open reading material (PDF)](https://codility.com/media/train/8-PrimeNumbers.pdf)

> _Easy_
> ### [CountFactors](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/)
> Count factors of given number n.

#### Task description
***
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

    class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [1..2,147,483,647].
***

#### Code Walkthrough
```java
class Solution {
    public int solution(int N) {
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
```

#### Conclusion
* Detected time complexity: O(sqrt(N))
* Detected space complexity: O(1)

[Codility Report](https://app.codility.com/demo/results/trainingPK74BK-RGW/)

***
