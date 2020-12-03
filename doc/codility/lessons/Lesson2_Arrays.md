# [Lesson 2 Arrays](https://app.codility.com/programmers/lessons/2-arrays/)
***
[Open reading material (PDF)](https://codility.com/media/train/0-Arrays.pdf)
***
## Tasks:
### [CyclicRotation](https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/)
Rotate an array to the right by a given number of steps.
---
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

`class Solution { public int[] solution(int[] A, int K); }`

**that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.**

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

* N and K are integers within the range [0..100];
* each element of array A is an integer within the range [−1,000..1,000].

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

#### Code
```
    public int[] solution(int[] A, int K) {
        int N = A.length;
        int[] B = new int[N];

        if (N > 0 && K > 0) {
            ArrayList<Integer> arrayB = new ArrayList<Integer>();

            for (int i = 0; i < N; i++) {
                arrayB.add(A[i]);
            }

            for (int j = 0; j < K; j++) {
                arrayB.add(0, arrayB.get(arrayB.size() - 1));
                arrayB.remove(arrayB.size() - 1);
            }

            for (int k = 0; k < arrayB.size(); k++) {
                B[k] = (int) arrayB.get(k);
            }
        } else {
            B = A;
        }

        return B;
    }
```
#### Candidate Report
[Candidate Report: training6HJBYX-26F](https://app.codility.com/demo/results/training6HJBYX-26F/)

***
_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***

### [OddOccurrencesInArray](https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/)
Find value that occurs in odd number of elements.
---
A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

```
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
```
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

`class Solution { public int solution(int[] A); }`

**that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.**

For example, given array A such that:

```
  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
```

the function should return 7, as explained in the example above.

Write an **efficient** algorithm for the following assumptions:

* N is an odd integer within the range [1..1,000,000];
* each element of array A is an integer within the range [1..1,000,000,000];
* all but one of the values in A occur an even number of times.

***
#### Code
```
    public int solution(int[] A) {
        int goal = 0;

        java.util.Arrays.sort(A);
        for (int i = 0; i < A.length -1; i++) {
            if (A[i] != A[i + 1]) {
                goal = A[i];
                break;
            }
            i++;
        }

        if (goal == 0) {
            goal =  A[A.length - 1];
        }

        return goal;
    }
```
***
* Detected time complexity:  O(N) or O(N*log(N))  
***
#### Candidate Report
[Candidate Report: training66EE8T-EUB](https://app.codility.com/demo/results/training66EE8T-EUB/)
***
_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***

