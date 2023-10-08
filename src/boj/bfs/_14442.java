package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14442 {

    static int N, M, K;

    static int[][] graph;

    static boolean[][][] visited;

    static int answer = 1;

    static int wallCnt;

    static class Node {
        int x;
        int y;
        int cur;
        int cnt;

        public Node(int x, int y, int cur, int cnt) {
            this.x = x;
            this.y = y;
            this.cur = cur;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) == '1' ? 1 : 0;
            }
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!pq.isEmpty()) {

            Node node = pq.poll();

            int x = node.x;
            int y = node.y;

            if (x == M - 1 && y == N - 1) {
                return node.cur;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if (graph[ny][nx] == 0 && !visited[ny][nx][node.cnt]) {
                    pq.add(new Node(nx, ny, node.cur + 1, node.cnt));
                    visited[ny][nx][node.cnt] = true;
                }
                else {
                    if (node.cnt < K && !visited[ny][nx][node.cnt + 1]) {
                        pq.add(new Node(nx, ny, node.cur + 1, node.cnt + 1));
                        visited[ny][nx][node.cnt + 1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
