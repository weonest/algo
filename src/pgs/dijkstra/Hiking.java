package pgs.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 등산코스 정하기
public class Hiking {

    class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

    }

    List<Node>[] graph;
    int[] intensity;
    boolean[] isSummit;
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        graph = new List[n + 1];
        intensity = new int[n + 1];
        isSummit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int summit : summits) {
            isSummit[summit] = true;
        }

        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int c = path[2];

            graph[u].add(new Node(v, c));
            graph[v].add(new Node(u, c));
        }

        dijkstra(gates);

        answer[1] = 10_000_001;

        for (int summit : summits) {
            if (intensity[summit] < answer[1]) {
                answer[1] = intensity[summit];
                answer[0] = summit;
            }
            if (intensity[summit] == answer[1] && summit < answer[0]) {
                answer[1] = intensity[summit];
                answer[0] = summit;
            }
        }

        return answer;
    }

    private int dijkstra(int[] gates) {
        Arrays.fill(intensity, 10000000);
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new Node(gate, 0));
        }
        while (!pq.isEmpty()) {
            int cur = pq.peek().dest;
            int cost = pq.poll().cost;

            if (cost > intensity[cur]) {
                continue;
            }

            for (Node next : graph[cur]) {
                if (intensity[next.dest] <= Math.max(cost, next.cost)) continue;
                intensity[next.dest] = Math.max(cost, next.cost);
                if (isSummit[next.dest]) continue;
                pq.offer(new Node(next.dest, intensity[next.dest]));
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Hiking h = new Hiking();
        System.out.println("정답은 = " + Arrays.toString(h.solution(6,
                new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},
                new int[]{1, 3},
                new int[]{5})));
    }
}
