_Lesson 12_
## [Euclidean algorithm](https://app.codility.com/programmers/lessons/12-euclidean_algorithm/)

***
[Open reading material (PDF)](https://codility.com/media/train/10-Gcd.pdf)

> _Easy_
> ### [ChocolatesByNumbers](https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/)
> There are N chocolates in a circle. Count the number of chocolates you will eat.

***

#### Task description

Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

```java
class Solution { public int solution(int N, int M); }
```


that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

* N and M are integers within the range [1..1,000,000,000].

***

#### Code Walkthrough

##### Intuitive

```java
class Solution {
    public int solution(int N, int M) {
        int maxChocolates = 0;

        for (int i = 0; i < N; i++) {
            java.util.Set<Integer> wrappers = new java.util.HashSet<>();
            int j = 0;
            int wrapper = i;
            while (wrappers.add(wrapper)) {
                j += 1;
                wrapper = (i + j*M) % N;
            }
            maxChocolates = Math.max(maxChocolates, wrappers.size());
        }
        return maxChocolates;
    }
}
```

Conclusion

* Detected time complexity: O(N + M)
* Detected space complexity: O(log N)

|Task Score|Correctness|Performance|
|---|---|---|
|50%|100%|0%|

[Codility Report](https://app.codility.com/demo/results/trainingK37QGH-8BJ/)

***

##### Optimized
This problem wants us to calculate gcd. because M*gcd will be the least common multiple(LCM) of M and N. For beginning to eat, when we meet the LCM, we got wrapper.

For examples: 

* N = 10, M = 4, gcd is 2, then the result will be N/gcd = 10/2 = 5, answer is 5.  
* N = 7, M = 4, gcd is 1, then N/gcd = 7/1 = 7, answer is 7.
* N = (3\*\*9)\*(2\*\*14), M=(2\*\*14)\*(2\*\*14), then N/gcd = 322486272/16384 = 19683, answer is 19683.

The Euclidean algorithm is one of the oldest numerical algorithms still to be in common
use. It solves the problem of computing the greatest common divisor (gcd) of two positive
integers.

Here is one java implementation of computing the gcd of N and M. 

```java
class Solution {
    public int solution(int N, int M) {
        return N / gcdBinary(N, M, 1);
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

Conclusion

* Detected time complexity: O(log(N + M))
* Detected space complexity: O(1)

|Task Score|Correctness|Performance|
|---|---|---|
|100%|100%|100%|

[Codility Report](https://app.codility.com/demo/results/trainingQZZJZY-MJ6/)

***
