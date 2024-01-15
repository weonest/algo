package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2606 {

    static int N, M;
    static List<Integer>[] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph[cur].add(next);
            graph[next].add(cur);
        }

        bfs(1);
        System.out.println(answer);
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] visit = new boolean[N + 1];
        visit[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int v : graph[cur]) {
                if (!visit[v]) {
                    visit[v] = true;
                    answer++;
                    q.add(v);
                }
            }
        }
    }
}
