package programmers.arrow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();


    @Test
    void test1() {
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] result = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};

        Assertions.assertThat(solution.solution(n, info)).containsExactly(result);
    }
    @Test
    void test2() {
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] result = {-1};

        Assertions.assertThat(solution.solution(n, info)).containsExactly(result);
    }

    @Test
    void test3() {
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};
        int[] result = {1,1,2,0,1,2,2,0,0,0,0};

        Assertions.assertThat(solution.solution(n, info)).containsExactly(result);
    }


}