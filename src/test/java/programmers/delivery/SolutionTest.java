package programmers.delivery;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test1() {
        int N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;

        int result = 4;

        Assertions.assertThat(solution.solution(N, road, K)).isEqualTo(result);
    }

    @Test
    void test2() {
        int N = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int K = 4;

        int result = 4;

        Assertions.assertThat(solution.solution(N, road, K)).isEqualTo(result);
    }
}