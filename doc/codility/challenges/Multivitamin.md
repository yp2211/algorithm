# [Codility Challenge](https://app.codility.com/programmers/challenges/)
## [The OLX Group challenge](https://app.codility.com/programmers/challenges/olx_group2020/)
_Start date: Nov. 6, 2020, 5 p.m. UTC_

**Tasks Details**

> _Medium_
> ### Multivitamin  
> There are N glasses of different capacities, each of them containing a different amount of a unique kind of juice. Calculate the maximum number of kinds of juice that can be mixed in a single glass.  

#### Task description
---
Rick is really fond of fruit juices, but he is bored of their traditional flavours. Therefore, he has decided to mix as many of them as possible to obtain something entirely new as a result.

He has N glasses, numbered from 0 to N-1, each containing a different kind of juice. The J-th glass has capacity[J] units of capacity and contains juice[J] units of juice. In each glass there is at least one unit of juice.

Rick want to create a multivitamin mix in one of the glasses. He is going to do it by pouring juice from several other glasses into the chosen one. Each of the used glasses must be empty at the end (all of the juice from each glass has to be poured out).

What is the maximum number of flavours that Rick can mix?

Write a function:

`class Solution { public int solution(int[] juice, int[] capacity); }`

that, given arrays juice and capacity, both of size N, returns the maximum number of flavours that Rick can mix in a single glass.

**Examples:**
1. Given juice = [10, 2, 1, 1] and capacity = [10, 3, 2, 2], your function should return 2. Rick can pour juice from the 3rd glass into the 2nd one.

2. Given juice = [1, 2, 3, 4] and capacity = [3, 6, 4, 4], your function should return 3. Rick can pour juice from the 0th and 2nd glasses into the 1st one.

3. Given juice = [2, 3] and capacity = [3, 4], your function should return 1. No matter which glass he chooses, Rick cannot pour juice from the other one into it. The maximum number of flavours in the chosen glass is 1.

4. Given juice = [1, 1, 5] and capacity = [6, 5, 8], your function should return 3. Rick can mix all juices in the 2nd glass.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [2..100,000];
* each element of arrays juice, capacity is an integer within the range [1..1,000,000,000];
* arrays juice and capacity have the same length, equal to N;
* for each J juice[J] ≤ capacity[J].

---
#### Solution 1  
> _Sliver_  

|  Task Score   | Correctness  | Performance |
|  ----  | ----  | ----  |
| 47%  | 100% | 0% |

**Detected time complexity:**    
[O(N**2 * log(N))](https://app.codility.com/cert/view/certBAHYYY-799W2CKH32G9GM4U/details/)
```
    public static int solution(int[] juice, int[] capacity) {

        int target = 1;

        // 1. sort
        int current;
        int currentCapacity;
        for (int i = 0; i < juice.length - 1; i++) {
            current = juice[i + 1];
            currentCapacity = capacity[i + 1];

            int preIndex = i;
            while (preIndex >= 0 && current < juice[preIndex]) {
                juice[preIndex + 1] = juice[preIndex];
                capacity[preIndex + 1] = capacity[preIndex];
                preIndex--;
            }
            juice[preIndex + 1] = current;
            capacity[preIndex + 1] = currentCapacity;
        }
//        System.out.println(java.util.Arrays.toString(juice));
//        System.out.println(java.util.Arrays.toString(capacity));


        // 2. mix
        int tempCount;
        for (int j = 0; j < juice.length; j++) {
            int left = capacity[j] - juice[j];

            if (left <= 0) continue;
            tempCount = 1;
            for (int k = 0; k < juice.length; k++) {
                if (k == j) continue;

                if (left >= juice[k]) {
                    tempCount += 1;
                    left = left - juice[k];

                    if (left <= 0) {
                        break;
                    }
                }
            }

            if (tempCount > target) {
                target = tempCount;
            }

        }

        return target;
    }

```
---
#### Solution 2  
|  Task Score   | Correctness  | Performance |
|  ----  | ----  | ----  |
| 47%  | 100% | 0% |
---
Detected time complexity:  
[O(N**2 * log(N))](https://app.codility.com/cert/view/certFGXQ3T-3PFT83HH28UPQ9AQ/details/)
```

```
***
_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***
