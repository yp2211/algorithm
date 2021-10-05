package codility.lessons.Lesson13_FibonacciNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FibonacciNumbersExercises {

    /*
     * 13.1: Finding Fibonacci numbers recursively.
     * O(n*n)
     */
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
     * 13.2: Finding Fibonacci numbers dynamically.
     * O(n)
     */
    public int fibonacciDynamic(int n) {
        int[] fib = new int[n+2];
        fib[1] = 1;

        for (int i = 2; i < n + 2; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public int fibonacciMatrix(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        /*
             -      -  i
            |  1  1  |
            |  1  0  |
             -      -
         */
        int[][] base = new int[][]{{1,1}, {1,0}}; // i = 1

        int i = 2;
        int[][] fib = new int[][]{{1,1}, {1,0}};
        while (i <= n) {
            int fibFn1 = fib[0][0]*fib[0][0] + fib[0][1]*fib[1][0];
            int fibFn =  fib[0][0]*fib[0][1] + fib[0][1]*fib[1][1];
            int fibFn_1 =fib[1][0]*fib[0][1] + fib[1][1]*fib[1][1];
            fib[0][0] = fibFn1;
            fib[0][1] = fibFn;
            fib[1][0] = fibFn;
            fib[1][1] = fibFn_1;
            if (i*2 <= n) i *= 2;
            else break;
        }

        while (i < n) {
            int fibFn1 = fib[0][0]*base[0][0] + fib[0][1]*base[1][0];
            int fibFn =  fib[0][0]*base[0][1] + fib[0][1]*base[1][1];
            int fibFn_1 =fib[1][0]*base[0][1] + fib[1][1]*base[1][1];
            fib[0][0] = fibFn1;
            fib[0][1] = fibFn;
            fib[1][0] = fibFn;
            fib[1][1] = fibFn_1;
            i+=1;
        }

        return fib[0][1];
    }

    public int fibonacciFormula(int n) {
        return (int) ((Math.pow((1+Math.sqrt(5))/2, n) - Math.pow((1-Math.sqrt(5))/2, n))/Math.sqrt(5));
    }

    /*
     * 1 <= x <= 1 000 000
     */
    public int[][] exercise(int[] X) {
        final int MAX_X = 1000000;
        ArrayList<Integer> fibs = new ArrayList<>();
        fibs.add(0);
        fibs.add(1);

        while (true) {
            int fib = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            fibs.add(fib);
            if (fib >= MAX_X) break;
        }
//        System.out.println(Arrays.toString(fibs.toArray()));

        HashMap<Integer, int[]> sums = new HashMap<>();
        for (int i = 0; i < fibs.size()-1; i++) {
            for (int j = i + 1; j < fibs.size(); j++) {
                int sum = fibs.get(i) + fibs.get(j);
                if (!sums.containsKey(sum)) sums.put(sum, new int[]{i, j});
            }
        }

        int[][] rtn = new int[X.length][2];
        for (int i = 0; i < X.length; i++) {
            if (sums.containsKey(X[i])) {
                rtn[i] = sums.get(X[i]);
            }
        }

        return rtn;
    }

}