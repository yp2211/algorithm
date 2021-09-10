package codility.lessons.Lesson7_StacksAndQueues;

public class StoneWall {
    public int solution(int[] H) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int result = 0;
        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty()) {
                Integer preStone = stack.pop();
                if (preStone == H[i]) {
                    // same height
                    stack.push(preStone);
                    break;
                } else if (H[i] > preStone) {
                    stack.push(preStone);
                    stack.push(H[i]);
                    break;
                } else {
                    result += 1;
                }
            }
            if (stack.isEmpty()) stack.push(H[i]);
        }
        return result + stack.size();
    }
}
