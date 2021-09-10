package codility.lessons.Lesson6_Sorting.Solutions;

import codility.lessons.Lesson6_Sorting.IDistinct;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingDeque;

/**
 * Created by peng.yang on ${Date}
 */
public class DistinctSolution implements IDistinct {

    @Override
    public int solution(int[] A) {
        // Time complexity: O(N)
        // Space complexity: O(N)
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        return set.size();
    }

}
