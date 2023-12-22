package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이
public class _1913 {

    static int N;
    static int[][] map;
    static int T;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        T = Integer.parseInt(br.readLine());

        make();

        StringBuilder sb = new StringBuilder();

        for (int[] arr : map) {
            for (int arr2 : arr) {
                sb.append(arr2 + " ");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = map[i][j];
                if (cur == T) {
                    System.out.print(i + 1 + " " + (j + 1));
                }
            }
        }
    }

    static void make() {
        int value = N * N;
        int x = 0;
        int y = 0;
        int dir = 0;
        map[0][0] = value--;

        while (value > 0) {
            if (map[x][y] == 1) {
                break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 0) {
                    map[nx][ny] = value--;
                    x = nx;
                    y = ny;
                    continue;
                }
                dir = (dir + 1) % 4;
            }
            else {
                dir = (dir + 1) % 4;
            }


        }
    }
}
