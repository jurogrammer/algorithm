package leetcode.array217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visit = new HashSet<>();
        for (int num : nums) {
            if (visit.contains(num)) {
                return true;
            }
            visit.add(num);
        }
        return false;
    }
}