package codility.lessons.Lesson7_StacksAndQueues;

public class Nesting {
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
//        return 1;
    }
}
