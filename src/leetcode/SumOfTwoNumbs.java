package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwoNumbs {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,4,5,6};
        int target = 10;
        System.out.println(Arrays.toString(flagMap(A, target)));
        System.out.println(Arrays.toString(halfSearch(A, target)));
        System.out.println(Arrays.toString(doublePoint(A, target)));
    }

    static int[] flagMap(int[] numbs, int target) {
        java.util.Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbs.length; i++) {
            int temp = target - numbs[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            } else {
                map.put(numbs[i], i);
            }
        }

        return new int[]{0};
    }

    static int[] halfSearch(int[] numbs, int target) {
        for (int i = 0; i < numbs.length; i++) {
            int low = i, high = numbs.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int temp = target - numbs[i];
                if (numbs[mid] == temp) {
                    return new int[] {i, mid};
                } else if (numbs[mid] > temp) {
                    high = mid - 1;
                } else {
                    low = mid +1;
                }
            }
        }
        return new int[]{0};
    }

    static int[] doublePoint(int[] numbs, int target) {
        int low = 0, high = numbs.length - 1;
        while (low < high) {
            int sum = numbs[low] + numbs[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{0};
    }
}
