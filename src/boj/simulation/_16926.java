package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _16926 {

    static int N, M, R, T;

    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        T = Math.min(N, M) / 2;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (R-- > 0) {
            roll();
        }
        for (int[] arr : map) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

    }

    static void roll() {
        for (int i = 0; i < T; i++) {
            int x = i;
            int y = i;

            int temp = map[x][y];

            int idx = 0;
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (nx >= i && ny >= i && nx < N - i && ny < M - i) {
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }
            map[i + 1][i] = temp;
        }
    }

}
