package yahoo;

import java.util.ArrayList;
import java.util.Scanner;

public class yahoo {
    public static void main(String[] args) {
        String[] lines = getStdin();
        if (lines.length < 2) { return; }

        int NUM_COUNT = Integer.parseInt(lines[0]);
        String[] list = lines[1].split(" ");
        long[] numlist = new long[list.length];

        for (int i = 0; i < list.length; i++) {
            numlist[i] = Long.parseLong(list[i]);
        }
        numlist = bubbleSort(numlist);

        String output1 = String.format("%d %d", numlist[0], numlist[numlist.length - 1]);
        System.out.println(output1);

        StringBuilder output2 = new StringBuilder();
        for (int i = 0; i < numlist.length; i++) {
            output2.append(numlist[i] + "");
        }
        System.out.println(output2.toString());
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
     * bubbleSort
     * @param array
     * @return
     */
    public static long[] bubbleSort(long[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    long temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

}
