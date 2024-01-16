package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 특정 거리의 도시 찾기
public class _18352 {

    static class City{
        int cur, dist;

        public City(int cur, int dist) {
            this.cur = cur;
            this.dist = dist;
        }
    }

    static int N, M, K, X;
    static List<Integer>[] graph;
    static PriorityQueue<Integer> answer = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph[cur].add(next);
        }

        dfs();

        StringBuilder sb = new StringBuilder();
        if (answer.isEmpty()) {
            System.out.print(-1);
        }
        else {
            for (int v : answer) {
                sb.append(v).append("\n");
            }
            sb.setLength(sb.length() - 1);
            System.out.print(sb);
        }

    }

    static void dfs() {
        Queue<City> q = new ArrayDeque<>();
        q.add(new City(X,0));
        boolean[] visit = new boolean[N + 1];
        visit[X] = true;

        while (!q.isEmpty()) {
            City city = q.poll();
            int cur = city.cur;
            int dist = city.dist;

            if (dist == K) {
                answer.offer(cur);
            }

            if (dist > K) {
                break;
            }

            for (int v : graph[cur]) {
                if (!visit[v]) {
                    visit[v] = true;
                    q.add(new City(v, dist + 1));
                }
            }
        }
    }

}
