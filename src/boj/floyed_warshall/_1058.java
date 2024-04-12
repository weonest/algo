package boj.floyed_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 친구
public class _1058 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {

            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                char c = str.charAt(j);

                answer[i][j] = c == 'Y' ? 1 : 9999;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k == i || i == j || j == k) continue;
                    answer[i][j] = Math.min(answer[i][j], answer[i][k] + answer[k][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (answer[i][j] <= 2) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

}
