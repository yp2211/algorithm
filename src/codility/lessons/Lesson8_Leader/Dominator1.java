package codility.lessons.Lesson8_Leader;

public class Dominator1 {
    public int solution(int[] A) {
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return 0;

        int[] B = A.clone();
        java.util.Arrays.sort(B);
        int mode = A.length % 2;
        int index = A.length / 2;
        int leader;
        if (mode == 1 || (mode == 0 && B[index] == B[index - 1] && (index + 1 < B.length && B[index] == B[index + 1]))) {
            leader = B[index];
        } else {
            return -1;
        }

        int resultIndex = -1;
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                counter++;
                if (resultIndex < 0 ) resultIndex = i;
            }
        }

        return counter > index ? resultIndex : -1;
    }
}
