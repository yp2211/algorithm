package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by peng.yang on ${Date}
 */
class TwoSumImplTest {
    @Test
    void solution() {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] expected = new int[] {0, 1};
        int[] actrual = (new TwoSumImpl()).solution(nums, target);
        Assertions.assertArrayEquals(expected, actrual);
    }

}