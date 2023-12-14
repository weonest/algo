package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빙고
public class _2578 {

    static int[][] map = new int[5][5];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int answer = 0;
        while (flag) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                answer++;
                int num = Integer.parseInt(st.nextToken());

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (map[k][l] == num) map[k][l] = 0;
                    }
                }
                rowCheck();
                colCheck();
                leftDiagonalCheck();
                rightDiagonalCheck();

                if (count >= 3) {
                    System.out.println(answer);
                    flag = false;
                    break;
                }
                count = 0;
            }
        }
    }

    static void rowCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) zeroCnt++;
            }
            if (zeroCnt == 5) count++;
        }
    }

    static void colCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == 0) zeroCnt++;
            }
            if (zeroCnt == 5) count++;
        }
    }

    static void leftDiagonalCheck() {
        int zeroCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == 0) zeroCnt++;
        }
        if (zeroCnt == 5) count++;
    }

    static void rightDiagonalCheck() {
        int zeroCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][4 - i] == 0) zeroCnt++;
        }
        if (zeroCnt == 5) count++;
    }

}
