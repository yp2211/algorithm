_Lesson10_
## [Prime and composite numbers](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/)

***
[Open reading material (PDF)](https://codility.com/media/train/8-PrimeNumbers.pdf)

> _Medium_
> ### [Peaks](https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/)
> Divide an array into the maximum number of same-sized blocks, each of which should contain an index P such that A[P - 1] < A[P] > A[P + 1].

### Task description
***
A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

has exactly three peaks: 3, 5, 10.

We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:

* A[0], A[1], ..., A[K − 1],
* A[K], A[K + 1], ..., A[2K − 1],
...
* A[N − K], A[N − K + 1], ..., A[N − 1].

What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).

The goal is to find the maximum number of blocks into which the array A can be divided.

Array A can be divided into blocks as follows:

* one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
* two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
* three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.

However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].

The maximum number of blocks that array A can be divided into is three.

Write a function:
```java
class Solution { public int solution(int[] A); }
```
that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.

If A cannot be divided into some number of blocks, the function should return 0.

For example, given:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [0..1,000,000,000].
***

### Code Walkthrough 1 (100%)
```java
class Solution {
    public int solution(int[] A) {
        int N = A.length;

        java.util.ArrayList<Integer> peaks = new java.util.ArrayList<>();
        for (int i = 1; i < N - 1; i++)
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) peaks.add(i);

        if (peaks.size() <= 1) return peaks.size();

        // E.G. N = 12, K=[1,2,3,4,6,12]
        for (int K = 1; K <= N; K++) {                  // K: block size
            if (N % K == 0) {
                int blocks = N / K;
                int currentBucket = 0;
                for (Integer peak : peaks) {
                    int peakBucket = peak / K;
                    if (peakBucket == currentBucket) {
                        // current bucket has been filled, then go to next bucket
                        currentBucket += 1;
                        // until last bucket is filled
                        if (currentBucket == blocks) break;
                    } else if (peakBucket > currentBucket) {
                        currentBucket = -1;
                        break;
                    }
                }

                if (currentBucket == blocks) return blocks;
            }
        }
        return 0;
    }
}
```

#### Conclusion
* Detected time complexity: O(N * log(log(N)))
* Detected space complexity: O(N)

[Codility Report](https://app.codility.com/demo/results/trainingK4SNQD-59Z/)

### Code Walkthrough 2 (100%)
Remember divisors by stack: 
```java
class Solution {
    public int solution(int[] A) {
        int result = 0;
        int N = A.length;

        java.util.ArrayList<Integer> peaks = new java.util.ArrayList<>();
        for (int i = 1; i < N - 1; i++)
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) peaks.add(i);

        if (peaks.size() <= 1) return peaks.size();

        int K = 1;      // elements number of one block
        int blocks;
        java.util.Stack<Integer> divisors = new java.util.Stack<>();
        // E.G. N = 12, K=[1,2,3]
        while (K * K <= N) {
            if (N % K == 0) {
                if (K * K == N) {
                    blocks = K;
                } else {
                    divisors.push(K);
                    blocks = N / K;
                }
                if (isOK(peaks, blocks, K)) return blocks;
            }
            K += 1;
        }

        while (!divisors.isEmpty()) {
            // E.G. N = 12, K=[1,2,3]
            //      blocks=[3,2,1] -> K=[4,6,12]
            blocks = divisors.pop();
            if (isOK(peaks, blocks, N / blocks)) return blocks;
        }

        return result;
    }

    private boolean isOK(java.util.ArrayList<Integer> peaks, int blocks, int k) {
        int currentBucket = 0;
        for (Integer peak : peaks) {
            int peakBucket = peak / k;
            if (peakBucket == currentBucket) {
                // current bucket is filled, then go to next bucket
                currentBucket += 1;
                // until last bucket is filled
                if (currentBucket == blocks) break;
            } else if (peakBucket > currentBucket) {
                currentBucket = -1;
                break;
            }
        }
        return currentBucket == blocks;
    }
}
```
#### Conclusion
* Detected time complexity: O(N * log(log(N)))
* Detected space complexity: O(N)

[Codility Report](https://app.codility.com/demo/results/trainingUS72XB-WNH/)

### Performance comparison

|TEST|DESCRIPTION|[Code 1](https://app.codility.com/demo/results/trainingK4SNQD-59Z/) | [Code 2(divisors)](https://app.codility.com/demo/results/trainingUS72XB-WNH/)|
|----|----|----|----|
|medium_random|chaotic medium sequences, length = ~5,000|1. 0.024 sOK<br>2. 0.016 sOK|1. 0.024 sOK<br>2. 0.016 sOK|
|medium_anti_slow|medium test anti slow solutions|1. 0.068 sOK|1. 0.068 sOK|
|large_random|chaotic large sequences, length = ~50,000|1. 0.192 sOK<br>2. 0.092 sOK|1. 0.192 sOK<br>2. **0.088** sOK|
|large_anti_slow|large test anti slow solutions|1. 0.136 sOK<br>2. 0.200 sOK|1. **0.140** sOK<br>2. **0.196** sOK|
|extreme_max|extreme max test|1. 0.224 sOK<br>2. 0.364 sOK|1. **0.220** sOK<br>2. 0.364 sOK|

***
