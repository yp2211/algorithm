_Lesson 6_
# [Sorting](https://app.codility.com/programmers/lessons/6-sorting/)
[Open reading material (PDF)](https://codility.com/media/train/4-Sorting.pdf)
***
## Tasks:

> _Painless_
> ### [Distinct](https://app.codility.com/programmers/lessons/6-sorting/distinct/)
> Compute number of distinct values in an array.

Write a function

`class Solution { public int solution(int[] A); }`

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

```
 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
```

the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [−1,000,000..1,000,000].

---
#### Code1

```java:
    public int solution(int[] A) {
        java.util.HashMap hm = new java.util.HashMap();
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], true);
        }
        return hm.size();
    }
```

Detected time complexity:

O(N*log(N)) or O(N)

#### Report1
[trainingC9WE4Y-E39](https://app.codility.com/demo/results/trainingC9WE4Y-E39/)

---
#### Code2

```java:
    public int solution(int[] A) {
        int goal = 0;
        int[] B = new int[2000001];
        for (int a : A) {
            B[1000000 + a]++;
        }

        for (int b : B) {
            if (b > 0) goal++;
        }

        return goal;
    }
```

Detected time complexity:

O(N*log(N)) or O(N)

#### Report2
[trainingKM7K8S-X97](https://app.codility.com/demo/results/trainingKM7K8S-X97/)

---

> _Painless_
> ### [MaxProductOfThree](https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/)
> Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).

A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

```js:example
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
```

contains the following example triplets:

* (0, 1, 2), product is −3 * 1 * 2 = −6
* (1, 2, 4), product is 1 * 2 * 5 = 10
* (2, 4, 5), product is 2 * 5 * 6 = 60

Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

```js:example
  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
```

the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [3..100,000];
* each element of array A is an integer within the range [−1,000..1,000].

---
#### 解く
![image.png](https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/196344/cd300b3b-0f02-876d-aa09-c3969a9c4bed.png)

#### Program

```java:
    public int solution(int[] A) {
        int max1 = -9999;
        int max2 = -9999;
        int max3 = -9999;
        int min2 = 9999;
        int min1 = 9999;

        for (int a : A) {
            if (a > max1) {
                max3 = max2;
                max2 = max1;
                max1 = a;
            } else if (a > max2) {
                max3 = max2;
                max2 = a;
            } else if (a > max3) {
                max3 = a;
            }

            if (a < min1) {
                min2 = min1;
                min1 = a;
            } else if (a < min2) {
                min2 = a;
            }
        }

        int maxProduct = max1 * max2 * max3;

        if (max1 <= 0 || min1 >= 0) {
            // 全て負 || 全て正
            return maxProduct;
        } else {
            if (min2 < 0 ) {
                // せめて2つ負
                int temp = max1 * min1 * min2;
                if (temp > maxProduct) return temp;
            }
        }

        return maxProduct;
    }
```
Detected time complexity:

O(N * log(N))

#### jUnit 

#### Report
[trainingUP9UFH-H2Y](https://app.codility.com/demo/results/trainingUP9UFH-H2Y/)

***

> _Respectable_
> ### [NumberOfDiscIntersections](https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/)
> Compute the number of intersections in a sequence of discs.

We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

```js:example
  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0
```
![](../../../resources/codility/lessons/NumberOfDiscIntersections.png)

There are eleven (unordered) pairs of discs that intersect, namely:

* discs 1 and 4 intersect, and both intersect with all the other discs;
* disc 2 also intersects with discs 0 and 3.

Write a function:

`class Solution { public int solution(int[] A); }`

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [0..2,147,483,647].

***
