package codility.lessons.Lesson7_StacksAndQueues;

public class StoneWall {
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
