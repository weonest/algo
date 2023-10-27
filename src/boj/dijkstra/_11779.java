package boj.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11779 {

    static int N, M;

    static class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static int MAX = 200_000_000;
    static int[] costs;
    static int[] route; // 지나온 길을 처리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        costs = new int[N + 1];
        route = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, c));
            graph[v].add(new Node(v, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
        List<Integer> list = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            list.add(cur);
            cur = route[cur];
        }
        System.out.println(list.size());
        Collections.reverse(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(costs, MAX);
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        pq.add(new Node(start, 0));
        costs[start] = 0;
        route[start] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.peek().dest;
            int cost = pq.poll().cost;

            if (cost > costs[cur]) {
                continue;
            }
            if (cur == end) break;

            for (Node next : graph[cur]) {
                if (costs[next.dest] > costs[cur] + next.cost) {
                    costs[next.dest] = costs[cur] + next.cost;
                    pq.offer(new Node(next.dest, costs[next.dest]));
                    route[next.dest] = cur;
                }
            }
        }
        return costs[end];
    }
}
