package programmers.arrow;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int[] info) {
        DFS dfs = new DFS(n, info);
        dfs.calculate();

        return dfs.maxArray;
    }

    public static class DFS {
        private int maxDiff = -1;
        private int[] maxArray = new int[]{-1};

        private int n;
        private int[] apeechInfos;

        public DFS(int n, int[] info) {
            this.n = n;
            this.apeechInfos = info;
        }

        public void calculate() {
            int[] rionInfos = new int[apeechInfos.length];
            Arrays.fill(rionInfos, 0);
            dfs(0, rionInfos, n);
        }

        public void dfs(int i, int[] rionInfos, int remainShot) {
            if (remainShot < 0) {
                return;
            }

            if (i >= rionInfos.length) {
                rionInfos[rionInfos.length - 1] += remainShot;
                int score = getDiffScore(apeechInfos, rionInfos);
                if (score < maxDiff) {
                    return;
                }

                if (score == maxDiff) {
                    for (int point = 0; point < apeechInfos.length; point++) {
                        int idx = 10 - point;
                        if (maxArray[idx] == rionInfos[idx]) {
                            continue;
                        }
                        if (maxArray[idx] < rionInfos[idx]) {
                            maxArray = rionInfos;
                            return;
                        }
                        return;
                    }
                    return;
                }

                maxDiff = score;
                maxArray = rionInfos;
                return;
            }

            // 점수따기
            int shot = apeechInfos[i] + 1;
            int[] ints = Arrays.copyOf(rionInfos, rionInfos.length);
            ints[i] = shot;
            dfs(i + 1, ints, remainShot - shot);
            // 점수따지 말기
            dfs(i + 1, Arrays.copyOf(rionInfos, rionInfos.length), remainShot);
        }

        private int getDiffScore(int[] apeechInfos, int[] rionInfos) {
            int apeechScore = 0;
            int rionScore = 0;

            for (int point = 0; point < apeechInfos.length; point++) {
                if (rionInfos[10 - point] == 0 && apeechInfos[10 - point] == 0) {
                    continue;
                }
                if (rionInfos[10 - point] > apeechInfos[10 - point]) {
                    rionScore += point;
                } else {
                    apeechScore += point;
                }
            }

            if (apeechScore >= rionScore) {
                return Integer.MIN_VALUE;
            }
            return rionScore - apeechScore;
        }
    }
}