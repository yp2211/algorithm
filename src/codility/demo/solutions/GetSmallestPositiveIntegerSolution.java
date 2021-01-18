package codility.demo.solutions;

import codility.demo.IGetSmallestPositiveInteger;
import utils.SizeOfObject;

/*
    This is a demo task.
    Write a function:
    class Solution { public int solution(int[] A); }
    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
        Given A = [1, 2, 3], the function should return 4.
        Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:
        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].

Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class GetSmallestPositiveIntegerSolution implements IGetSmallestPositiveInteger {
    private final int MAX = 1000000;

    @Override
    public int solution(int[] A) {

        int target = MAX;

        byte[] B = new byte[MAX + 1];
        for (int aA : A) {
            if (aA >= 0) {
                B[aA] = 1;
            }
        }

        for (int j = 1; j < B.length; j++) {
            if (B[j] <= 0) {
                target = j;
                break;
            }
        }

//        System.out.println(String.format("Size of B: %d", SizeOfObject.sizeOf(B)));

        return target;
    }

    public int invoke2(int[] A) {

        int target = MAX;

        int[] B = new int[MAX + 1];
        for (int aA : A) {
            if (aA >= 0) {
                B[aA] = 1;
            }
        }

        for (int j = 1; j < B.length; j++) {
            if (B[j] <= 0) {
                target = j;
                break;
            }
        }
        System.out.println(String.format("Size of B: %d", SizeOfObject.sizeOf(B)));
        return target;
    }
}
