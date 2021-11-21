package yahoo;

import java.util.ArrayList;
import java.util.Scanner;

public class g2021 {
    private static final long MOD = 100003;

    public static int main(String[] args) {
//        String[] lines = getStdin();
//        if (lines.length < 2) { return; }
        int N = 10;
        String[] list = "1 1 1 1 1 1 1 1 1 1".split(" ");
        if (args != null && args.length > 1) {
            N = Integer.parseInt(args[0]);
            list = args[1].split(" ");
        }

//        int N = 11;
//        String[] list = "1 1 1 1 1 1 1 1 1 1 2".split(" ");

//        int N = 100000;
//        String[] list = new String[100000];
//        for (int i = 0; i < list.length; i++) {
//            if (i < 3) {
//                list[i] = "1";
//            } else {
////            list[i] = "1";
//                list[i] = i + "";
//            }
//        }

        int[] numlist = new int[100001];

        int numCount = 0;
        for (int i = 0; i < list.length; i++) {
            int num = Integer.parseInt(list[i]);
            if (numlist[num] <= 0) { numCount += 1; }

            numlist[num] += 1;
        }

        long out = 1;
        for (int i = 1; i < numCount; i++) {
            out = (2 * out) % MOD;
        }

        for (int num : numlist) {
            if (num > 1) {
                out = (out * ((long)(customizedFactorial(num, MOD))));
            }
        }

        System.out.println(out % MOD);
        return (int)(out % MOD);
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    public static long factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static long customizedFactorial(long number, long mod) {
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial = factorial * i;
            if (factorial > mod) {
                factorial = factorial % mod;
            }
        }
        return factorial;
    }
}
