_Lesson 5_
# [Prefix Sums](https://app.codility.com/programmers/lessons/5-prefix_sums/)
[Open reading material (PDF)](https://codility.com/media/train/3-PrefixSums.pdf)
***
## Tasks:
> _Respectable_
> ### [CountDiv](https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/)
> Compute number of integers divisible by k in range [a..b].

Write a function:

`class Solution { public int solution(int A, int B, int K); }`

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

`{ i : A ≤ i ≤ B, i mod K = 0 }`

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an **efficient** algorithm for the following assumptions:

* A and B are integers within the range [0..2,000,000,000];
* K is an integer within the range [1..2,000,000,000];
* A ≤ B.

#### Code
```
    public int solution(int A, int B, int K) {
        return (int)(Math.floor(B / (double)K)) - (int)(Math.ceil(A / (double)K)) + 1;
    }
```
Detected time complexity:  
O(1)
#### Report
[Candidate Report: trainingMUJ282-CCG](https://app.codility.com/demo/results/trainingMUJ282-CCG/)
***

> _Respectable_  
> ### [GenomicRangeQuery](https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/)
> Find the minimal nucleotide from a range of sequence DNA.

A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:
```
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
```
The answers to these M = 3 queries are as follows:

* The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
* The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
* The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

`class Solution { public int[] solution(String S, int[] P, int[] Q); }`

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:
```
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
```
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* M is an integer within the range [1..50,000];
* each element of arrays P, Q is an integer within the range [0..N − 1];
* P[K] ≤ Q[K], where 0 ≤ K < M;
* string S consists only of upper-case English letters A, C, G, T.

#### Code
```
    public int[] solution(String S, int[] P, int[] Q) {
        int[] goal = new int[P.length];
        int[][] prefixSums = new int[3][S.length() + 1];
        int[] DNA = new int[]{1, 2, 3, 4};
        short a, c, g;
        for (int i = 0; i < S.length(); i++) {
            a = 0;
            c = 0;
            g = 0;
            switch (S.charAt(i)) {
                case 'A':
                    a = 1;
                    break;
                case 'C':
                    c = 1;
                    break;
                case 'G':
                    g = 1;
                    break;
                default:
                    break;
            }
            prefixSums[0][i + 1] = prefixSums[0][i] + a;
            prefixSums[1][i + 1] = prefixSums[1][i] + c;
            prefixSums[2][i + 1] = prefixSums[2][i] + g;
        }

        for (int j = 0; j < P.length; j++) {
            int from = P[j];
            int to = Q[j] + 1;
            if (prefixSums[0][to] - prefixSums[0][from] > 0) {
                goal[j] = DNA[0];
            } else if (prefixSums[1][to] - prefixSums[1][from] > 0) {
                goal[j] = DNA[1];
            } else if (prefixSums[2][to] - prefixSums[2][from] > 0) {
                goal[j] = DNA[2];
            } else {
                goal[j] = DNA[3];
            }
        }

        return goal;
    }

```
Detected time complexity:  
O(N + M)

#### Report
[trainingEJ6PEK-VQT/](https://app.codility.com/demo/results/trainingEJ6PEK-VQT/)
***

> _Respectable_  
> ### [MinAvgTwoSlice](https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/)  
> Find the minimal average of any slice containing at least two elements.

A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:
```
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
```
contains the following example slices:

* slice (1, 2), whose average is (2 + 2) / 2 = 2;
* slice (3, 4), whose average is (5 + 1) / 2 = 3;
* slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:
```
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
```
the function should return 1, as explained above.

Write an **efficient** algorithm for the following assumptions:

* N is an integer within the range [2..100,000];
* each element of array A is an integer within the range [−10,000..10,000].

#### Code

```java:MinAvgTwoSliceSolution.java
    public int solution(int[] A) {
        int goal = 0;
        int[] P = new int[A.length + 1];
        P[0] = 0;
        for (int i = 0; i < A.length; i++) {
            P[i + 1] = P[i] + A[i];
        }

        double minAvg = 10000;
        for(int j = 0; j < A.length - 1; j++) {
            double currentAvg2 = (double)(P[j + 2] - P[j]) / 2;
            if (currentAvg2 < minAvg) {
                minAvg = currentAvg2;
                goal = j;
            }

            if (j == A.length - 2) break;;

            double currentAvg3 = (double)(P[j + 3] - P[j]) / 3;
            if (currentAvg3 < minAvg) {
                minAvg = currentAvg3;
                goal = j;
            }
        }

        return goal;
    }
```
Detected time complexity:

O(N)

#### Report
[trainingP37RME-WBC](https://app.codility.com/demo/results/trainingP37RME-WBC/)
***

> _Painless_  
> ### [PassingCars](https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/)
> Count the number of passing cars on the road.

A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

* 0 represents a car traveling east,
* 1 represents a car traveling west.

The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:
```
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
```
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

Write a function:

`class Solution { public int solution(int[] A); }`

that, given a non-empty array A of N integers, returns the number of pairs of passing cars.

The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.

For example, given:
```
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
```
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer that can have one of the following values: 0, 1.

#### Code
[PassingCarsSolution.java]()

```java:PassingCarsSolution.java
    public int solution(int[] A) {
        int goal = 0;
        int[] P = new int[A.length + 1];
        P[0] = 0;
        for (int i = 0; i < A.length; i++) {
            P[i + 1] = P[i] + A[i];
        }

        for (int j = 0; j < A.length - 1; j++) {
            if (A[j] == 0) {
                goal += P[P.length - 1] - P[j + 1];
                if (goal > 1000000000) {
                    return -1;
                }
            }
        }

        return goal;
    }
```
Detected time complexity:  
O(N)

#### Report
[trainingJC2BAT-X4S](https://app.codility.com/demo/results/trainingJC2BAT-X4S/)
***
_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***