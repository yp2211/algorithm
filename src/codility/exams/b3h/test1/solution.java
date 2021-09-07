package codility.exams.b3h.test1;

public class solution {

    void solution(int N) {
        // write your code in Java SE 11
        final String l = "L";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append(l);
            if (i < N - 1) {
                System.out.println(l);
            } else {
                System.out.println(sb);
            }
        }
    }
}
