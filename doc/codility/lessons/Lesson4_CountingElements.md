_Lesson 4_
# [Counting Elements](https://app.codility.com/programmers/lessons/4-counting_elements/)

[Open reading material (PDF)](https://codility.com/media/train/2-CountingElements.pdf)
***
## Tasks:

> _Painless_
> ### [FrogRiverOne](https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/)
> Find the earliest time when a frog can jump to the other side of a river.

A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:
```
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
```
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

`class Solution { public int solution(int X, int[] A); }`

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:
```
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
```
the function should return 6, as explained above.

Write an **efficient** algorithm for the following assumptions:

* N and X are integers within the range [1..100,000];
* each element of array A is an integer within the range [1..X].

#### Code
```
    public int solution(int X, int[] A) {
        int goal = -1;
        int B[] = new int[X + 1];
        java.util.Arrays.fill(B, -1);
        for (int i = 0; i < A.length; i++) {
            if (B[A[i]] < 0 || B[A[i]] > i) {
                B[A[i]] = i;
            }
        }

        for (int j = 1; j < B.length; j ++) {
            int anB = B[j];
            if (anB < 0) {
                goal = -1;
                break;
            } else {
                goal = goal < anB ? anB : goal;
            }
        }

        return goal;
    }
```
Detected time complexity:  
O(N)
#### Report
[Candidate Report: training933GQH-AM9](https://app.codility.com/demo/results/training933GQH-AM9/)
***
> _Respectable_
> ### [MaxCounters](https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/)
> Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.

You are given N counters, initially set to 0, and you have two possible operations on them:

* increase(X) − counter X is increased by 1,
* max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

* if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
* if A[K] = N + 1 then operation K is max counter.

For example, given integer N = 5 and array A such that:
```
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
```
the values of the counters after each consecutive operation will be:
```
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
```
The goal is to calculate the value of every counter after all operations.

Write a function:

`class Solution { public int[] solution(int N, int[] A); }`

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:
```
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
```
the function should return [3, 2, 2, 4, 2], as explained above.

Write an **efficient** algorithm for the following assumptions:

* N and M are integers within the range [1..100,000];
* each element of array A is an integer within the range [1..N + 1].

#### Code
```
    public int[] solution(int N, int[] A) {
        int[] B = new int[N];
        int currentMaximumValue = 0;
        int minValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                if (minValue < currentMaximumValue) {
                    minValue = currentMaximumValue;
                }
            } else {
                if (B[A[i] - 1] < minValue) {
                    B[A[i] - 1] = minValue;
                }

                B[A[i] - 1] += 1;
                if (B[A[i] - 1] > currentMaximumValue) currentMaximumValue = B[A[i] - 1];
            }
        }
        for (int j = 0; j < B.length; j++) {
            B[j] = B[j] < minValue ? minValue : B[j];
        }

        return B;
    }
```
Detected time complexity:  
O(N + M)
#### Report
[Candidate Report: training9KQG2K-34P](https://app.codility.com/demo/results/training9KQG2K-34P/)
***

> _Respectable_
> ### [MissingInteger](https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/)
> Find the smallest positive integer that does not occur in a given sequence.

This is a demo task.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

* Given A = [1, 2, 3], the function should return 4.

* Given A = [−1, −3], the function should return 1.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [−1,000,000..1,000,000].

#### Code
```
    public int solution(int[] A) {
        boolean[] B = new boolean[1000001];
        java.util.Arrays.fill(B, false);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                B[A[i]] = true;
            }
        }
        for (int j = 1; j < B.length; j++) {
            if (!B[j]) return j;
        }

        return 1000001;
    }
```
Detected time complexity:  
O(N) or O(N * log(N))
#### Report
[Candidate Report: training33X6JS-SN7](https://app.codility.com/demo/results/training33X6JS-SN7/)
***

> _Painless_  
> ### [PermCheck](https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/)
> Check whether array A is a permutation.

A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:
```
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
```
is a permutation, but array A such that:
```
    A[0] = 4
    A[1] = 1
    A[2] = 3
```
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:
```
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
```
the function should return 1.

Given array A such that:
```
    A[0] = 4
    A[1] = 1
    A[2] = 3
```
the function should return 0.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [1..1,000,000,000].

#### Code
```
    public int solution(int[] A) {
        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i + 1) continue;
            else return 0;
        }

        return 1;
    }
```
Detected time complexity:  
O(N) or O(N * log(N))
#### Report
[Candidate Report: trainingVGBR4Z-S47](https://app.codility.com/demo/results/trainingVGBR4Z-S47/)
***

_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***
