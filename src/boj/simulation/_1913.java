package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이
public class _1913 {

    static int N;
    static int[][] map;
    static int T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        T = Integer.parseInt(br.readLine());

        int value = N * N;
        int limit = N;

        int x = 0;
        int y = 0;
        int t = 0;

        while (value > 0) {
            x = t;
            for (int i = y; i < limit; i++) {
                map[i][x] = value--;
            }

            y = limit - 1;
            for (int i = x + 1; i < limit; i++) {
                map[y][i] = value--;
            }

            x = limit - 1;
            for (int i = y - 1; i >= t; i--) {
                map[i][x] = value--;
            }

            y = t;
            for (int i = x - 1; i > t; i--) {
                map[y][i] = value--;
            }
            t++;
            y++;
            limit--;
        }

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
}
