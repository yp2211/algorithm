_Lesson9_
## [Maximum slice problem](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/)

***
[Open reading material (PDF)](https://codility.com/media/train/7-MaxSlice.pdf)

> _Easy_
> ### [MaxSliceSum](https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/)
> Find a maximum sum of a compact subsequence of array elements.

#### Task description
***
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:
```java
class Solution { public int solution(int[] A); }
```

that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:
```
A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
```
the function should return 5 because:

* (3, 4) is a slice of A that has sum 4,
* (2, 2) is a slice of A that has sum −6,
* (0, 1) is a slice of A that has sum 5,
* no other slice of A has sum greater than (0, 1).

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [1..1,000,000];
* each element of array A is an integer within the range [−1,000,000..1,000,000];
* the result will be an integer within the range [−2,147,483,648..2,147,483,647].
***

#### Source code
```java
class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;

        int P = 0, S = A[0], S1 = A[0];
        for (int Q = 1; Q < A.length; Q++) {
            if (A[Q] < 0 && S1 + A[Q] < 0) {
                P = Q;
                S1 = A[Q];
            } else {
                S1 += A[Q];
                for (int i = P; i < Q; i++) {
                    if (A[i] < 0 || (P + 1 < Q && A[P] + A[P + 1] < 0)) {
                        P = i + 1;
                        S1 -= A[i];
                    } else {
                        break;
                    }
                }
            }

            if (S1 > S) S = S1;
        }
        return S;
    }
}
```

#### Detected time complexity:
O(N)

#### Detected space complexity:
O(1)


#### Report
[trainingDGFQTR-Z9J](https://app.codility.com/demo/results/trainingDGFQTR-Z9J/)

***
