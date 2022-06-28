package programmers.receive_report_result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution solution = new Solution();
    @Test
    void test() {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = {2,1,1,0};
        Assertions.assertThat(solution.solution(id_list,report,k)).containsExactly(result);
    }

}