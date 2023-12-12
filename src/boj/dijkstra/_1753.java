package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753{

    static int V, E;

    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;

    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new List[V + 1];
        costs = new int[V + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);


        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, c));
        }

        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            if (costs[i] > 60_000_000) System.out.println("INF");
            else System.out.println(costs[i]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        costs[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.peek().dest;
            int cost = pq.poll().cost;

            if (cost > costs[cur]) {
                continue;
            }

            for (Node next : graph[cur]) {
                if (costs[next.dest] > costs[cur] + next.cost) {
                    costs[next.dest] = costs[cur] + next.cost;
                    pq.offer(new Node(next.dest, costs[next.dest]));
                }
            }
        }
    }
}
