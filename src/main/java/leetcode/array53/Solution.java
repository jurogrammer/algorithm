package leetcode.array53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int accVal = 0;
        for (int num : nums) {
            accVal = Math.max(num, accVal + num);
            max = Math.max(max, accVal);
        }
        return max;
    }
}