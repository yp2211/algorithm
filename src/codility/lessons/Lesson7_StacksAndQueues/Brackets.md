_Lesson7_

## [Stacks and Queues](https://app.codility.com/programmers/lessons/7-stacks_and_queues/)
***
[Open reading material (PDF)](https://codility.com/media/train/5-Stacks.pdf)

> _Easy_
> ### [Brackets](https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/)
> Determine whether a given string of parentheses (multiple types) is properly nested.

#### Task description
***
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

* S is empty;
* S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
* S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:
```
class Solution { public int solution(String S); }
```
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..200,000];
* string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
***

#### Source code
```java
class Solution {
    public int solution(String S) {
        java.util.Map<String, String> charPairs = new java.util.HashMap<>();
        charPairs.put(")", "(");
        charPairs.put("}", "{");
        charPairs.put("]", "[");

        java.util.Stack<String> stack = new java.util.Stack();
        for (char c : S.toCharArray()) {
            String currentFlag = String.valueOf(c);
            if (charPairs.containsKey(currentFlag)) {
                // this is an ending flag
                if (stack.isEmpty()) return 0;

                String s = stack.pop();
                if (!charPairs.get(currentFlag).equals(s)) {
                    return 0;
                }
            } else {
                stack.push(currentFlag);
            }
        }

        if (stack.isEmpty()) return 1;

        return 0;
    }
}
```

#### Detected time complexity:
O(N)

#### Report
[trainingM8HRVS-HKZ](https://app.codility.com/demo/results/trainingM8HRVS-HKZ/)
***
