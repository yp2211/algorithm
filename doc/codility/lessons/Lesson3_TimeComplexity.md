_Lesson 3_
# [Time Complexity](https://app.codility.com/programmers/lessons/3-time_complexity/)
***
[Open reading material (PDF)](https://codility.com/media/train/1-TimeComplexity.pdf)
***
## Tasks:
> _Painless_
> ### [FrogJmp](https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/)
> Count minimal number of jumps from position X to Y.
***
A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

`class Solution { public int solution(int X, int Y, int D); }`

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:
```
  X = 10
  Y = 85
  D = 30
```
the function should return 3, because the frog will be positioned as follows:

* after the first jump, at position 10 + 30 = 40
* after the second jump, at position 10 + 30 + 30 = 70
* after the third jump, at position 10 + 30 + 30 + 30 = 100

Write an **efficient** algorithm for the following assumptions:

* X, Y and D are integers within the range [1..1,000,000,000];
* X ≤ Y.

#### Code
```
    public int solution(int X, int Y, int D) {
        return (int) Math.ceil ((double) (Y - X) / D);
    }
```
Detected time complexity:  
O(1)
#### Report
[Candidate Report: trainingBFBAZF-EXF](https://app.codility.com/demo/results/trainingBFBAZF-EXF/)
***
***
> _Painless_
> ### [PermMissingElem](https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/)
> Find the missing element in a given permutation.
***
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given an array A, returns the value of the missing element.

For example, given array A such that:
```
  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
```
the function should return 4, as it is the missing element.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* the elements of A are all distinct;
* each element of array A is an integer within the range [1..(N + 1)].
***

#### Code1
```
    public int solution(int[] A) {
        if (A.length == 0) return 1;

        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if ((i + 1) != A[i]) return i + 1;
        }
        return A.length + 1;
    }
```
Detected time complexity:  
O(N) or O(N * log(N))
#### Report1
[Candidate Report: trainingBAC3YW-77U](https://app.codility.com/c/run/trainingBAC3YW-77U/)
***
#### Code2
```
    public int solution(int[] A) {
        boolean[] bucket = new boolean[100000 + 2];
        java.util.Arrays.fill(bucket, false);
        for (int anA : A) {
            bucket[anA] = true;
        }
        for (int i = 1; i < bucket.length; i++) {
            if (!bucket[i]) {
                return i;
            }
        }

        return 1;
    }
```
Detected time complexity:  
O(N) or O(N * log(N))
#### Report2
[Candidate Report: training28V8U4-VDE](https://app.codility.com/c/run/training28V8U4-VDE/)
***
***
> _Painless_
> ### [TapeEquilibrium](https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/)
> Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
***
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:
```
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
```
We can split this tape in four places:

* P = 1, difference = |3 − 10| = 7
* P = 2, difference = |4 − 9| = 5
* P = 3, difference = |6 − 7| = 1
* P = 4, difference = |10 − 3| = 7

Write a function:

`class Solution { public int solution(int[] A); }`

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:
```
  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
```
the function should return 1, as explained above.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [2..100,000];
* each element of array A is an integer within the range [−1,000..1,000].
***
#### Code
```
    public int solution(int[] A) {
        int difference = 0;
        int sumPart1 = 0;
        int sumPart2 = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        sumPart1 = A[0];
        sumPart2 = sum - sumPart1;
        difference = Math.abs(sumPart1 - sumPart2);
        for (int p = 2; p < A.length; p++) {
            sumPart1 += A[p - 1];
            sumPart2 -= A[p - 1];
            int temp = Math.abs(sumPart1 - sumPart2);
            if (temp < difference) {
                difference = temp;
            }
        }

        return difference;
    }
```
Detected time complexity:  
O(N)
#### Report
[Candidate Report: trainingAVSN2R-5SF](https://app.codility.com/demo/results/trainingAVSN2R-5SF/)
***
_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***
