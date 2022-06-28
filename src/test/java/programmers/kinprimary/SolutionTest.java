package programmers.kinprimary;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void test() {
        int n = 437674;
        int k = 3;

        int result = 3;

        assertThat(solution.solution(n, k)).isEqualTo(result);
    }

    @Test
    void test2() {
        int n = 5;
        int k = 2;

        int result = 0;

        assertThat(solution.solution(n, k)).isEqualTo(result);
    }
}