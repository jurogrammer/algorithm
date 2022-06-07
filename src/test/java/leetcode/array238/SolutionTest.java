package leetcode.array238;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = {24, 12, 8, 6};

        Assertions.assertThat(solution.productExceptSelf(nums)).containsExactly(result);
    }

    @Test
    void test2() {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] result = {0, 0, 9, 0, 0};

        Assertions.assertThat(solution.productExceptSelf(nums)).containsExactly(result);
    }


}