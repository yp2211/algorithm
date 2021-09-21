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

### Brute force approach

#### Code Walkthrough
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


### Improve approach ( Dynamic Programming )

Dynamic Programming is a method for solving a complex problem by breaking it down into a collection of simpler subproblems, solving each of those subproblems just once, and storing their solutions using a memory-based data structure (array, map, etc.). So the next time the same sub-problem occurs, instead of recomputing its solution, one simply looks up the previously computed solution, thereby saving computation time.

> [How should I explain dynamic programming to a 4-year-old?](https://www.quora.com/How-should-I-explain-dynamic-programming-to-a-4-year-old/answer/Jonathan-Paulson)    
*writes down "1+1+1+1+1+1+1+1 =" on a sheet of paper*    
"What's that equal to?"  
*counting* "Eight!"  
*writes down another "1+" on the left*  
"What about that?"  
*quickly* "Nine!"  
"How'd you know it was nine so fast?"  
"You just added one more"  
"So you didn't need to recount because you remembered there were eight! Dynamic Programming is just a fancy way to say 'remembering stuff to save time later'"  

Some other information: 
> [Maximum subarray problem](https://en.wikipedia.org/wiki/Maximum_subarray_problem)   
> [Kadane’s Algorithm — (Dynamic Programming) — How and Why does it Work?](https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d)  

#### Code Walkthrough

```java
class Solution {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;

        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int a : A) {
            localMax = Math.max(a + localMax, a);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }
}
```
Note that instead of using an array to store local_maximums, we are simply storing the latest local_maximum in an int type variable ‘local_max’ because that’s what we need to calculate next local_maximum. Also, as we are using a variable ‘global_max’ to keep track of the maximum value of local_maximum, which in the end comes out to be the required output.

#### Conclusion
Because of the way this algorithm uses optimal substructures (the maximum subarray ending at each position is calculated in a simple way from a related but smaller and overlapping subproblem: the maximum subarray ending at the previous position) this algorithm can be viewed as a simple example of dynamic programming. Kadane’s algorithm is able to find the maximum sum of a contiguous subarray in an array with a runtime of O(n).

* Detected time complexity: O(N)
* Detected space complexity: O(1)

[Codility Report](https://app.codility.com/demo/results/trainingGED7G4-3TR/)

***
