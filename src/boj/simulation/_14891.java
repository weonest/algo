package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _14891 {

    static int[][] wheel = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            roll(idx, dir);
        }

        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += Math.pow(2, i) * wheel[i][0];
        }
        System.out.println(total);
    }

    static void roll(int idx, int dir) {
        leftWheel(idx - 1, -dir);
        rightWheel(idx + 1, -dir);
        rotation(idx, dir);
    }

    static void leftWheel(int idx, int dir) {
        if (idx < 0 ) return;
        if (wheel[idx][2] == wheel[idx + 1][6]) return;
        leftWheel(idx -1, -dir);
        rotation(idx, dir);
    }

    static void rightWheel(int idx, int dir) {
        if (idx > 3) return;
        if (wheel[idx - 1][2] == wheel[idx][6]) return;
        rightWheel(idx + 1, -dir);
        rotation(idx, dir);
    }

    static void rotation(int idx, int dir) {
        if (dir == 1) {
            int tmp = wheel[idx][7];
            for (int i = 7; i > 0; i--) {
                wheel[idx][i] = wheel[idx][i - 1];
            }
            wheel[idx][0] = tmp;
        } else {
            int tmp = wheel[idx][0];
            for (int i = 0; i < 7; i++) {
                wheel[idx][i] = wheel[idx][i + 1];
            }
            wheel[idx][7] = tmp;
        }
    }

}
