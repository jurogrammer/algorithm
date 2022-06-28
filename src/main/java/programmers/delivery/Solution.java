package programmers.delivery;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 다익스트라 참고: https://www.youtube.com/watch?v=oDnh117Bzn4 (권오흠 교수님, 그래프이론 제 3강)
 * https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
 *
 * S = S
 * notS = S바
 * label = 라벨 값
 */
public class Solution {
    public int solution(int N, int[][] road, int K) {
        // node는 1씩 감소하여 본다.
        int[][] graph = new int[N][N];

        for (int r = 0; r < N; r++) {
            Arrays.fill(graph[r], Integer.MAX_VALUE);
        }

        for (int i = 0; i < road.length; i++) {
            int[] abc = road[i];
            int fromNode = abc[0] - 1;
            int toNode = abc[1] - 1;
            int distance = abc[2];

            if (graph[fromNode][toNode] != Integer.MAX_VALUE) {
                graph[fromNode][toNode] = Math.min(graph[fromNode][toNode], distance);
                graph[toNode][fromNode] = Math.min(graph[fromNode][toNode], distance);
                continue;
            }
            graph[fromNode][toNode] = distance;
            graph[toNode][fromNode] = distance;
        }

        int[] label = new int[N];
        Arrays.fill(label, Integer.MAX_VALUE);
        label[0] = 0;

        Set<Integer> s = new HashSet<>();
        Set<Integer> notS = new HashSet<>();
        for (int i = 0; i < N; i++) {
            notS.add(i);
        }

        while (!notS.isEmpty()) {
            int u = -1;
            int minLabelVal = Integer.MAX_VALUE;
            for (Integer i : notS) {
                if (minLabelVal <= label[i]) {
                    continue;
                }

                minLabelVal = label[i];
                u = i;
            }

            s.add(u);
            notS.remove(u);

            for (int toNode = 0; toNode < N; toNode++) {
                int newVtxToNotS = graph[u][toNode] == Integer.MAX_VALUE ? Integer.MAX_VALUE : minLabelVal + graph[u][toNode];
                label[toNode] = Math.min(label[toNode], newVtxToNotS);
            }
        }

        long count = Arrays.stream(label).filter(distance -> distance <= K).count();

        return (int) count;
    }
}