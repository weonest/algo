package pgs.graph;

import java.util.*;


// 가장 먼 노드
public class FurthestNode {

    static List<Integer>[] graph;
    static int[] dist;

    public static int solution(int n, int[][] edge) {
        List<Integer> answer = new ArrayList<>();
        graph = new List[n + 1];
        dist = new int[n + 1];
//        Arrays.fill(dist, -1);

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] node : edge) {
            int u = node[0];
            int v = node[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (dist[next] == 0) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        return 0;
    }

    public static void main(String[] args) {
        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}
