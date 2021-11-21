package yahoo;

import java.util.ArrayList;
import java.util.Scanner;

public class yahooShellSort {

    public static void main(String[] args) {
        String[] lines = getStdin();
        if (lines.length < 2) { return; }

        int NUM_COUNT = Integer.parseInt(lines[0]);
        String[] list = lines[1].split(" ");
        long[] numlist = new long[list.length];

        for (int i = 0; i < list.length; i++) {
            numlist[i] = Long.parseLong(list[i]);
        }
        numlist = ShellSort(numlist);

        String output1 = String.format("%d %d", numlist[0], numlist[numlist.length - 1]);
        System.out.println(output1);

        for (int i = 0; i < numlist.length; i++) {
            System.out.print(numlist[i]);
        }
        System.out.println("");
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * ShellSort
     *
     * @param array
     * @return
     */
    public static long[] ShellSort(long[] array) {
        int len = array.length;
        long temp = 0;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
