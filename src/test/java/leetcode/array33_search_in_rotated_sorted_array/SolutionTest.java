package leetcode.array33_search_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void test1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = 4;

        assertThat(solution.search(nums, target)).isEqualTo(result);
    }

    @Test
    void test2() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        int result = -1;

        assertThat(solution.search(nums, target)).isEqualTo(result);
    }

    @Test
    void test3() {
        int[] nums = {1};
        int target = 0;
        int result = -1;

        assertThat(solution.search(nums, target)).isEqualTo(result);
    }

    @Test
    void test4() {
        int[] nums = {1};
        int target = 1;
        int result = 0;

        assertThat(solution.search(nums, target)).isEqualTo(result);
    }

    @Test
    void test5() {
        int[] nums = {1,3};
        int target = 3;
        int result = 1;

        assertThat(solution.search(nums, target)).isEqualTo(result);
    }

}