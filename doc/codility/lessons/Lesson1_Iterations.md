_Lesson 1_

# [Iterations](https://app.codility.com/programmers/lessons/1-iterations/)  

[Open reading material (PDF)](https://codility.com/media/train/Iterations.pdf)

## Tasks:
> _Painless_  
> ### [BinaryGap](https://app.codility.com/programmers/lessons/1-iterations/binary_gap/)  
> Find longest sequence of zeros in binary representation of an integer.

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

`class Solution { public int solution(int N); }`

**that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.**

For example:  
* Given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. 
* Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

**Write an efficient algorithm for the following assumptions:**

* N is an integer within the range [1..2,147,483,647].

#### Program 1
Report: [trainingC78Z7J-BPG](https://app.codility.com/demo/results/trainingC78Z7J-BPG/)
```java:BinaryGap.java
    public int solution(int N) {
        int goal = 0;

        String binaryN = Integer.toBinaryString(N);
        char[] charsBinaryN = binaryN.toCharArray();

        int counter = 0;
        boolean counterSwitch = false;
        for (int i = 0; i < charsBinaryN.length; i++) {
            if (charsBinaryN[i] == '0') {
                counterSwitch = true;
                counter++;
            } else if (charsBinaryN[i] == '1') {
                if (counterSwitch) {
                    counterSwitch = false;
                    if (counter > goal) {
                        goal = counter;
                    }
                    counter = 0;
                } else {
                    continue;
                }
            }
        }

        return goal;
    }
```

#### Program 2
Report: [trainingPPEWCY-ENN/](https://app.codility.com/demo/results/trainingPPEWCY-ENN/)
```java:BinaryGapShifter.java
    public static int solution(int N) {
        int goal = 0;
        int counter = 0;
        boolean counterSwitch = false;
        while (N > 0) {
            if ((N & 1) == 1) {
                if (counterSwitch) {
                    if (counter > goal) goal = counter;

                    counter = 0;
                } else {
                    counterSwitch = true;
                }
            } else {
                if (counterSwitch) counter++;
            }

            N = N >> 1;
        }

        return goal;
    }
```
***

_Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited._
***