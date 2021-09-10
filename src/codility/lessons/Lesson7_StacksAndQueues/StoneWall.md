## [Stacks and Queues](https://app.codility.com/programmers/lessons/7-stacks_and_queues/)
***
[Open reading material (PDF)](https://codility.com/media/train/5-Stacks.pdf)

> _Easy_
> ### [StoneWall](https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/)
> Cover "Manhattan skyline" using the minimum number of rectangles.




#### Task description
***

You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by an array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:
```java
class Solution { public int solution(int[] H); }
```
that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

```
H[0] = 8    H[1] = 8    H[2] = 5
H[3] = 7    H[4] = 9    H[5] = 8
H[6] = 7    H[7] = 4    H[8] = 8
```

the function should return 7. The figure shows one possible arrangement of seven blocks.

![](https://codility-frontend-prod.s3.amazonaws.com/media/task_static/stone_wall/static/images/auto/4f1cef49cc46d451e88109d449ab7975.png)

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..100,000];
* each element of array H is an integer within the range [1..1,000,000,000].

***

#### Source code
```java
class StoneWall {
    public int solution(int[] H) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int result = 0;
        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty()) {
                Integer preStone = stack.pop();
                if (preStone == H[i]) {
                    // same height should be merged, so it is enough that we push one stone back to stack
                    stack.push(preStone);
                    break;
                } else if (H[i] > preStone) {
                    // new wall is higher, so we should push it into the stack,
                    // because we need one more stone to build higher wall
                    stack.push(preStone);
                    stack.push(H[i]);
                    break;
                } else {
                    // In this case, previous stone is higher,so we can not merge the new one to previous stone,
                    // we should pop previous stone out(what we have done), and record 1 to used stones.
                    result += 1;

                    // Then we should pop more one previous stone,
                    // and finding out that if the new one should merge to it or not.
                    // So we continue to the next loop.
                }
            }

            // If the stack is empty, it means: 
            //   maybe the new wall is the first wall, 
            //   maybe the new wall is so low that we have popped all stones from the stack yet.
            // Anyway, we should push it into stack, and go to next wall.
            if (stack.isEmpty()) stack.push(H[i]);
        }
        // Finally, the number of blocks is we recorded ones, and the number of stones which are still in our stack.
        return result + stack.size();
    }
}

```

#### Detected time complexity:
O(N)

#### Report
[trainingRUSQYU-852](https://app.codility.com/demo/results/trainingRUSQYU-852/)

***
