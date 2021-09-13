_Lesson7_
## [Stacks and Queues](https://app.codility.com/programmers/lessons/7-stacks_and_queues/)
***
[Open reading material (PDF)](https://codility.com/media/train/5-Stacks.pdf)

> _Easy_
> ### [Nesting](https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/)
> Determine whether a given string of parentheses (single type) is properly nested.



#### Task description
***
A string S consisting of N characters is called properly nested if:

* S is empty;
* S has the form "(U)" where U is a properly nested string;
* S has the form "VW" where V and W are properly nested strings.

For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:
```java
class Solution { public int solution(String S); }
```

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..1,000,000];
* string S consists only of the characters "(" and/or ")".

***

#### Source code
```java
class Solution {
    public int solution(String S) {
        java.util.Stack<String> stack = new java.util.Stack();
        for (char c : S.toCharArray()) {
            String currentFlag = String.valueOf(c);
            if ("(".equals(currentFlag)) {
                stack.push(currentFlag);
            } else {
                if (stack.isEmpty() || !"(".equals(stack.pop())) return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
```

#### Detected time complexity:
O(N)

#### Report
[training5KXWDU-R3T](https://app.codility.com/demo/results/training5KXWDU-R3T/)

***
