package leetcode.solutions;

import leetcode.ITwoSum;

/**
 * Created by peng.yang on ${Date}
 */
public class TwoSumSolution implements ITwoSum {
    @Override
    public int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        };

        return null;
    }
}
