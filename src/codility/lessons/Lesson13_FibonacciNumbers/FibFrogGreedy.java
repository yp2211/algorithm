package codility.lessons.Lesson13_FibonacciNumbers;

import java.util.ArrayList;

public class FibFrogGreedy {
    public int solution(int[] A) {
        final int MAX_X = 100000;
        ArrayList<Integer> fibs = getFibs(MAX_X);

        if (contains(fibs, A.length + 1)) return 1;

        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) continue;
            int distance = i + 1;
            if (contains(fibs, distance)) {
                A[i] = 1;
                continue;
            }

            A[i] = 0;
            for (int j = 0; j < i; j++) {
                if(A[j] == 0) continue;
                distance = i - j;
                if (contains(fibs, distance)) {
                    if (A[i] == 0) A[i] = A[j] + 1;
                    else A[i] = Math.min(A[i], A[j] + 1);  // Local optimal solution
                }
            }
        }

        int step = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) continue;
            int distance = A.length - i;
            if (contains(fibs, distance)) {
                step = Math.min(step, A[i] + 1);  // Global optimal solution
            }
        }

        return step == Integer.MAX_VALUE ? -1 : step;
    }

    private boolean contains(ArrayList<Integer> fibs, int x) {
        for (Integer fib : fibs) {
            if (fib > x) return false;
            if (fib == x) return true;
        }
        return false;
    }

    private ArrayList<Integer> getFibs(int MAX_X) {
        ArrayList<Integer> fibs = new ArrayList<>();
        int fib_1 = 1;
        int fib_2 = 1;
        fibs.add(1);
        int fib;
        do {
            fib = fib_1 + fib_2;
            fibs.add(fib);
            fib_2 = fib_1;
            fib_1 = fib;
        } while (fib < MAX_X);

        return fibs;
    }
}
