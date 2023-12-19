package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17276 {

    static int N;
    static int time;

    static int[][] map, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            copy = new int[N][N];

            int d = Integer.parseInt(st.nextToken());
            if (d < 0) d += 360;
            time = d / 45;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = map[i][j];
                }
            }

            while (time-- > 0) {
                roll();
            }

            for (int[] arr : map) {
                for (int a : arr) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }

        }
    }

    static void roll() {
        int mid = N / 2;
        for (int i = 0; i < N; i++) {
            copy[i][mid] = map[i][i];
            copy[i][i] = map[mid][i];
            copy[mid][i] = map[N - i - 1][i];
            copy[i][N - i - 1] = map[i][mid];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = copy[i][j];
            }
        }
    }

}


