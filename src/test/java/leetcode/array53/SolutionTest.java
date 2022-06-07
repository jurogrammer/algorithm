package leetcode.array53;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = 6;

        Assertions.assertThat(solution.maxSubArray(nums)).isEqualTo(result);
    }

    @Test
    void test2() {
        int[] nums = new int[]{1};
        int result = 1;

        Assertions.assertThat(solution.maxSubArray(nums)).isEqualTo(result);
    }

    @Test
    void test3() {
        int[] nums = new int[]{5,4,-1,7,8};
        int result = 23;

        Assertions.assertThat(solution.maxSubArray(nums)).isEqualTo(result);
    }

}