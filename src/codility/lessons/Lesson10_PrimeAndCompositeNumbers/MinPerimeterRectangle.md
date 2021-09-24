_Lesson10_
## [Prime and composite numbers](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/)

***
[Open reading material (PDF)](https://codility.com/media/train/8-PrimeNumbers.pdf)

> _Easy_
> ### [MinPerimeterRectangle](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/)
> Find the minimal perimeter of any rectangle whose area equals N.


#### Task description
***
An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

* (1, 30), with a perimeter of 62,
* (2, 15), with a perimeter of 34,
* (3, 10), with a perimeter of 26,
* (5, 6), with a perimeter of 22.

Write a function:
```java
class Solution { public int solution(int N); }
```

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [1..1,000,000,000].
***

#### Code Walkthrough
```java
class Solution {
    public int solution(int N) {
        int i = 1;
        int minPerimeter  = Integer.MAX_VALUE;
        while (i * i <= N) {
            if (N % i == 0) {
                int A = i;
                int B = N / i;
                minPerimeter = Math.min(minPerimeter, 2 * (A + B));
            }
            i++;
        }

        return minPerimeter;
    }
}
```

#### Conclusion
* Detected time complexity: O(sqrt(N))
* Detected space complexity: O(log N)

[Codility Report](https://app.codility.com/demo/results/trainingYJZV3F-V7N/)

***
