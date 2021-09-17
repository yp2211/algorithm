_Lesson8_
## [Leader](https://app.codility.com/programmers/lessons/8-leader/)

***
[Open reading material (PDF)](https://codility.com/media/train/6-Leader.pdf)

> _Easy_
> ### [EquiLeader](https://app.codility.com/programmers/lessons/8-leader/equi_leader/)
> Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.

#### Task description
***
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:
```
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
```
we can find two equi leaders:

* 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
* 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

The goal is to count the number of equi leaders.

Write a function:
```java
class Solution { public int solution(int[] A); }
```
that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:
```
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
```

the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

***

#### Source code
```java
class Solution {
    public int solution(int[] A) {
        if (A == null || A.length <= 1) return 0;

        // get leader
        java.util.HashMap<Integer, Integer> counter = new java.util.HashMap<>();

        int dominatorCount = A.length / 2;
        int leader = -1;
        for (int i = 0; i < A.length; i++) {
            int aCount = 1;
            if (counter.containsKey(A[i])) {
                aCount += counter.get(A[i]);
            }

            if (aCount > dominatorCount) {
                leader = A[i];
            }
            counter.put(A[i], aCount);
        }
        if (!counter.containsKey(leader)) return 0;

        int leaderTotal = counter.get(leader);

        // get EquiLeader
        int S = 0;
        int leaderCounter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                leaderCounter += 1;
            }

            int preLeaderNum =  (i + 1) / 2;                        // 0 ~ S
            int postLeaderNum = (A.length - i - 1) / 2;             // S+1 ~ N
            if (leaderCounter > preLeaderNum && (leaderTotal - leaderCounter) > postLeaderNum) {
                S++;
            }
        }
        return S;
    }
}
```

#### Detected time complexity:
O(N)

#### Detected space complexity:
O(N)

#### Report
[trainingSKVZYP-UJT](https://app.codility.com/demo/results/trainingSKVZYP-UJT/)

***
