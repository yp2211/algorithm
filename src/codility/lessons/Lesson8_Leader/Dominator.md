_Lesson8_
## [Leader](https://app.codility.com/programmers/lessons/8-leader/)

***
[Open reading material (PDF)](https://codility.com/media/train/6-Leader.pdf)

> _Easy_
> ### [Dominator](https://app.codility.com/programmers/lessons/8-leader/dominator/)
> Find an index of an array such that its value occurs at more than half of indices in the array.

#### Task description
***
An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that
```
A[0] = 3    A[1] = 4    A[2] =  3
A[3] = 2    A[4] = 3    A[5] = -1
A[6] = 3    A[7] = 3
```

The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function
```java
class Solution { public int solution(int[] A); }
```
that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that
```
A[0] = 3    A[1] = 4    A[2] =  3
A[3] = 2    A[4] = 3    A[5] = -1
A[6] = 3    A[7] = 3
```
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
***

#### Source code 1
```java
class Solution {
    public int solution(int[] A) {
        java.util.HashMap<Integer, Integer> counter = new java.util.HashMap<>();

        int dominatorCount = A.length / 2;
        for (int i = 0; i < A.length; i++) {
            int aCount = 0;
            if (counter.containsKey(A[i])) {
                aCount = counter.get(A[i]) + 1;
            } else {
                aCount = 1;
            }

            if (aCount > dominatorCount) {
                return i;
            } else {
                counter.put(A[i], aCount);
            }
        }
        return -1;
    }
}
```

#### Detected time complexity:
O(N)

#### Detected space complexity:
O(N)

#### Report
[trainingDYEBM7-G8B](https://app.codility.com/demo/results/trainingDYEBM7-G8B/)


#### Source code 2
```java
class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return 0;

        int[] B = A.clone();
        java.util.Arrays.sort(B);
        int mode = A.length % 2;
        int index = A.length / 2;
        int leader;
        if (mode == 1 || (mode == 0 && B[index] == B[index - 1] && (index + 1 < B.length && B[index] == B[index + 1]))) {
            leader = B[index];
        } else {
            return -1;
        }

        int resultIndex = -1;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                counter++;
                if (resultIndex < 0 ) resultIndex = i;
            }
        }

        return counter > index ? resultIndex : -1;
    }
}
```

#### Detected time complexity:
O(N*log(N)) or O(N)

#### Detected space complexity:
O(1)

#### Report
[trainingH2QNRG-EWM](https://app.codility.com/demo/results/trainingH2QNRG-EWM/)

***
