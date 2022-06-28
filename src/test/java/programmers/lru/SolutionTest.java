package programmers.lru;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test1() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int result = 50;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test2() {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int result = 21;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test3() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int result = 60;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test4() {
        int cacheSize = 5;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        int result = 52;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test5() {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int result = 16;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test6() {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int result = 25;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test7() {
        int cacheSize = 4;
        String[] cities = {"1","2","3","4", "2"};
        int result = 21;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }

    @Test
    void test8() {
        int cacheSize = 3;
        String[] cities = {"A","B","A"};
        int result = 11;

        assertThat(solution.solution(cacheSize, cities)).isEqualTo(result);
    }
}