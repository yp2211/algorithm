package yahoo;

import java.util.ArrayList;
import java.util.Scanner;

public class f2021 {
    public static void main(String[] args) {
        String[] lines = getStdin();
        if (lines.length < 1) { return; }

        String[] list = lines[0].split(" ");
        if (list.length < 3) { return; }

        long n = Long.parseLong(list[0]);
        long m = Long.parseLong(list[1]);
        long k = Long.parseLong(list[2]);

        long hunMax = m * (k - 1);
        long out = 0;
        if (hunMax >= n) {
            out = m;
        } else {
            out = m - (n - hunMax);
        }

        System.out.println(out);
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
