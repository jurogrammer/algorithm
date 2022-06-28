package programmers.kinprimary;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int share = n;
        while (share > 0) {
            int digitNumber = share % k;
            sb.append(digitNumber);
            share = share / k;
        }
        long[] numbers;

        String nums = sb.reverse().toString();
        numbers = Arrays.stream(nums.split("0+")).map(Long::parseLong).mapToLong(i -> i).toArray();

        int answer = 0;
        for (long number : numbers) {
            if (isPrimary(number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrimary(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}