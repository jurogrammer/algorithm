package programmers.lru;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */

/**
 * 고려해야 할 것
 * 1. hit 했을 경우 time을 초기화 해야 함. 여기선 old Data를 삭제한 후 priority queue에 삭제 후 추가하는 방식으로 구현
 * 2. miss 했을 경우엔 최근 것을 삭제
 * 3. 다른 사람 것 보니 LinkedhashMap으로 쉽게 구현 가능. 중복된 값을 put한 경우 최신으로
 */
public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int cacheHitExecTime = 1;
        int cacheMissExeTime = 5;

        if (cacheSize == 0) {
            return CalculateExecTime(cacheHitExecTime, cacheMissExeTime, 0, cities.length);
        }

        LRU lruCache = new LRU(cacheSize);
        int cacheHitCnt = 0;
        int cacheMissCnt = 0;

        for (int time = 0; time < cities.length; time++) {
            Data data = new Data(cities[time], time);
            if (lruCache.isHit(data)) {
                lruCache.hit(data);
                cacheHitCnt++;
            } else {
                lruCache.replace(data);
                cacheMissCnt++;
            }


        }
//        Queue<Data> cache = lruCache.cache;
//        int size = cache.size();
//        for (int i = 0; i < size; i++) {
//            Data remove = cache.remove();
//            System.out.println("remove = " + remove);
//        }
        return CalculateExecTime(cacheHitExecTime, cacheMissExeTime, cacheHitCnt, cacheMissCnt);
    }

    private int CalculateExecTime(int cacheHitExecTime, int cacheMissExeTime, int cacheHitCnt, int cacheMissCnt) {
        return cacheHitExecTime * cacheHitCnt + cacheMissExeTime * cacheMissCnt;
    }


    private static class LRU {
        private Set<String> storedCities;
        private Map<String, Data> cityToData; // LRU에서 삭제할 때 time 까지 알아야 해서.
        private Queue<Data> cache;
        private int maxSize;

        public LRU(int maxSize) {
            storedCities = new HashSet<>();
            cache = new PriorityQueue<>();
            this.maxSize = maxSize;
            this.cityToData = new HashMap<>();
        }

        public boolean isHit(Data data) {
            return storedCities.contains(data.city);
        }

        public void hit(Data data) {
            Data priorData = cityToData.get(data.city);
            cache.remove(priorData);

            cityToData.put(data.city, data);
            cache.add(data);

        }

        public void replace(Data data) {
            if (cache.size() < maxSize) {
                add(data);
                return;
            }
            remove();
            add(data);
        }

        private void add(Data data) {
            cache.add(data);
            storedCities.add(data.city);
            cityToData.put(data.city, data);
        }

        private void remove() {
            Data removedData = cache.remove();
            storedCities.remove(removedData.city);
            cityToData.remove(removedData.city);
        }
    }

    private static class Data implements Comparable<Data> {
        private String city;
        private int time;

        public Data(String city, int time) {
            this.city = city.toLowerCase();
            this.time = time;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.time, o.time);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return time == data.time && Objects.equals(city, data.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, time);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "city='" + city + '\'' +
                    ", time=" + time +
                    '}';
        }
    }
}
