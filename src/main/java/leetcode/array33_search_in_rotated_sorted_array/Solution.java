package leetcode.array33_search_in_rotated_sorted_array;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r) / 2;

        int leftVal = nums[l];
        int rightVal = nums[r];
        int middleVal = nums[m];

        while (l < r) {
            m = (l + r) / 2;
            leftVal = nums[l];
            rightVal = nums[r];
            middleVal = nums[m];

            if (middleVal == target) {
                return m;
            }
            if (middleVal < rightVal) {
                r = m - 1;
                continue;
            }
            if (middleVal > rightVal) {
                l = m + 1;
                continue;
            }
        }
        if (leftVal == target) {
            return l;
        }
        if (rightVal == target) {
            return r;
        }

        if (middleVal == target) {
            return m;
        }

        return -1;
    }
}
