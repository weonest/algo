package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class _11725 {

    static int N;
    static List<Integer>[] graph;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        graph = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int nex = Integer.parseInt(st.nextToken());

            graph[cur].add(nex);
            graph[nex].add(cur);
        }

        bfs();
        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int v : graph[cur]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parents[v] = cur;
                    q.add(v);
                }
            }
        }

    }
}
