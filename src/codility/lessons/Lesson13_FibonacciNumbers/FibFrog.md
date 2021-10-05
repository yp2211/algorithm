_Lesson13_
## [Fibonacci numbers](https://app.codility.com/programmers/lessons/13-fibonacci_numbers/)

***
[Open reading material (PDF)](https://codility.com/media/train/11-Fibonacci.pdf)

> _Medium_
> ### [FibFrog](https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/)
> Count the minimum number of jumps required for a frog to get to the other side of a river.

#### Task description
***
The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2

A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

* 0 represents a position without a leaf;
* 1 represents a position containing a leaf.

The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer that can have one of the following values: 0, 1.

***

#### Code Walkthrough

##### Intuitive

```java
import java.util.ArrayList;

public class Solution {
    public int solution(int[] A) {
        final int MAX_X = 100000;
        ArrayList<Integer> fibs = getFibs(MAX_X);

        if (fibs.contains(A.length + 1)) return 1;

        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) continue;
            int distance = i + 1;
            if (contains(fibs, distance)) {
                A[i] = 1;
                continue;
            }

            A[i] = 0;
            for (int j = 0; j < i; j++) {
                if(A[j] == 0) continue;
                distance = i - j;
                if (contains(fibs, distance)) {
                    if (A[i] == 0) A[i] = A[j] + 1;
                    else A[i] = Math.min(A[i], A[j] + 1);  // Local optimal solution
                }
            }
        }

        int step = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) continue;
            int distance = A.length - i;
            if (contains(fibs, distance)) {
                step = Math.min(step, A[i] + 1);  // Global optimal solution
            }
        }

        return step == Integer.MAX_VALUE ? -1 : step;
    }

    private boolean contains(ArrayList<Integer> fibs, int x) {
        for (Integer fib : fibs) {
            if (fib > x) return false;
            if (fib == x) return true;
        }
        return false;
    }

    private ArrayList<Integer> getFibs(int MAX_X) {
        ArrayList<Integer> fibs = new ArrayList<>();
        int fib_1 = 1;
        int fib_2 = 1;
        fibs.add(1);
        int fib;
        do {
            fib = fib_1 + fib_2;
            fibs.add(fib);
            fib_2 = fib_1;
            fib_1 = fib;
        } while (fib < MAX_X);

        return fibs;
    }
}
```

Conclusion

* Detected time complexity: O(N<sup>2</sup>)
* Detected space complexity: O(1)

|Task Score|Correctness|Performance|
|---|---|---|
|50%|100%|0%|

[Codility Report](https://app.codility.com/demo/results/trainingPXVBVN-43D/)

***

##### Optimized

```java

```

Conclusion

* Detected time complexity: O(log(N + M))
* Detected space complexity: O(1)

|Task Score|Correctness|Performance|
|---|---|---|
|100%|100%|100%|

[Codility Report]()


### More: [CodilityのLessonsをすべて解く（更新中）](https://qiita.com/yp2211/items/537f733060bb0f2aba8f)