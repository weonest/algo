package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 로봇 청소기
public class _14503 {

    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(row, col, dir);
        System.out.println(answer);

    }

    static void bfs(int row, int col, int dir) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col, dir});

        while (!q.isEmpty()) {
            int[] machine = q.poll();
            int curRow = machine[0];
            int curCol = machine[1];
            int curDir = machine[2];

            if (map[curRow][curCol] == 0) {
                map[curRow][curCol] = 2;
                answer++;
            }

            int condition = 0;
            for (int i = 0; i < 4; i++) {
                int nRow = curRow + dx[i];
                int nCol = curCol + dy[i];
                if (nRow >= 0 && nCol >= 0 && nRow < N && nCol < M && map[nRow][nCol] == 0) {
                    condition++;
                }
            }

            if (condition == 0) {
                int nRow = curRow - dx[curDir];
                int nCol = curCol - dy[curDir];

                if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= M || map[nRow][nCol] == 1) {
                    return;
                } else {
                    q.add(new int[]{nRow, nCol, curDir});
                }
            } else {
                int nDir = (curDir + 3) % 4;
                int nRow = curRow + dx[nDir];
                int nCol = curCol + dy[nDir];

                if (nRow >= 0 && nCol >= 0 & nRow < N && nCol <M && map[nRow][nCol] == 0) {
                    q.add(new int[]{nRow, nCol, nDir});
                } else {
                    q.add(new int[]{curRow, curCol, nDir});
                }
            }
        }

    }
}
