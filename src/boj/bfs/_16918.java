package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16918 {

    static int R, C, N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 2; i <= N; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (map[j][k] == 'O') {
                            q.add(new int[]{j, k});
                        }
                    }
                }
                for (char[] arr : map) {
                    Arrays.fill(arr, 'O');
                }
                bfs(q);
            }
        }

        if (N % 2 == 0) {
            for (char[] arr : map) {
                Arrays.fill(arr, 'O');
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            map[x][y] = '.';

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] == 'O') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }
    }
}
