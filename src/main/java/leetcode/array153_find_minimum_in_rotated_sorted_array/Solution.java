package leetcode.array153_find_minimum_in_rotated_sorted_array;

/**
 *  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int midVal = 5001;

        while (l <= r) {
            int m = (l + r) / 2;
            int leftVal = nums[l];
            int rightVal = nums[r];
            midVal = nums[m];

            if (l == m) {
                return midVal;
            }
            if (midVal < rightVal) {
                r = m - 1;
                continue;
            }

            if (midVal > rightVal) {
                l = m + 1;
                continue;
            }
        }

        return midVal;
    }
}
