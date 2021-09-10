package codility.lessons.Lesson7_StacksAndQueues;

public class Fish {
    public int solution(int[] A, int[] B) {
        java.util.Stack<Integer[]> stack = new java.util.Stack<>();

        for (int i = 0; i < A.length; i++) {
            Integer[] currentFish = new Integer[] {A[i], B[i]};
            if (currentFish[1] == 0) {
                // up
                while (!stack.isEmpty()) {
                    Integer[] preFish = stack.pop();
                    if (preFish[1] == 0) {
                        // up up
                        stack.push(preFish);
                        stack.push(currentFish);
                        break;
                    } else {
                        // down vs up
                        if (preFish[0] > currentFish[0]) {
                            // down win
                            stack.push(preFish);
                            break;
                        }
                        /* up win -> continue up
                        else {
                            continue;
                        }
                         */
                    }
                }
                if (stack.isEmpty()) {
                    stack.push(currentFish);
                }
            } else {
                //down
                stack.push(currentFish);
            }
        }
        return stack.size();
    }
}
