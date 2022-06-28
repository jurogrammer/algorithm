package programmers.notCorrupted;

import java.util.Objects;

public class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] curIdxes = new int[board.length][board[0].length];
        int[][][] map = new int[board.length][board[0].length][1000];

        for (int[] sk : skill) {
            int type = sk[0];
            int r1 = sk[1];
            int c1 = sk[2];
            int r2 = sk[3];
            int c2 = sk[4];
            int degree = sk[5];

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    int curIdx = curIdxes[r][c];
                    if (type == 1) {
                        map[r][c][curIdx] = degree * (-1);
                    } else {
                        map[r][c][curIdx] = degree;
                    }
                    curIdxes[r][c]++;
                }
            }
        }

        int answer = 0;
        return answer;
    }
}