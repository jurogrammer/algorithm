package leetcode.array238;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // idx = i번째 product 계산시 오른쪽의 총 곱셈 값.
        int lastIdx = nums.length - 1;
        int[] rightHand = new int[nums.length];
        rightHand[lastIdx] = 1;
        for (int ri = lastIdx - 1; ri >= 0; ri--) {
            rightHand[ri] = rightHand[ri + 1] * nums[ri + 1];
        }

        int[] leftHand = new int[nums.length];
        leftHand[0] = 1;
        for (int li = 1; li < leftHand.length; li++) {
            leftHand[li] = leftHand[li - 1] * nums[li - 1];
        }


        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftHand[i] * rightHand[i];
        }


        return result;
    }
}