package leetcode.array121;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void solution1() {
        int[] prices = {7,1,5,3,6,4};
        int result = 5;

        assertThat(solution.maxProfit(prices)).isEqualTo(result);

    }

    @Test
    void solution2() {
        int[] prices = {7,6,4,3,1};
        int result = 0;

        assertThat(solution.maxProfit(prices)).isEqualTo(result);

    }
}