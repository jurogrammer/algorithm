package leetcode.array153_find_minimum_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();
    @Test
    void test() {
        int[] nums = {3,4,5,1,2};
        int result = 1;

        assertThat(solution.findMin(nums)).isEqualTo(result);
    }

    @Test
    void test2() {
        int[] nums = {4,5,6,7,0,1,2};
        int result = 0;

        assertThat(solution.findMin(nums)).isEqualTo(result);
    }

    @Test
    void test3() {
        int[] nums = {11,13,15,17};
        int result = 11;

        assertThat(solution.findMin(nums)).isEqualTo(result);
    }

    @Test
    void test4() {
        int[] nums = {0,1};
        int result = 0;

        assertThat(solution.findMin(nums)).isEqualTo(result);
    }

}