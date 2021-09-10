package codility.lessons.Lesson7_StacksAndQueues;

public class Brackets {
    /*
     *   N is an integer within the range [0..200,000];
     *   string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
     */
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
