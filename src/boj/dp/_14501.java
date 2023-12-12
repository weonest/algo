package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501 {

    static int N;
    static int[][] schedule;
    static int totalPay = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int ttc = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            schedule[i][0] = ttc;
            schedule[i][1] = pay;
        }

        dfs(0, 0);

        System.out.println(totalPay);

    }

    static void dfs(int idx, int pay) {
        if (idx >= N) {
            totalPay = Math.max(pay, totalPay);
            return;
        }

        if (idx + schedule[idx][0] <= N) { // 상담을 끝마칠 수 있다면
            dfs(idx + schedule[idx][0], pay + schedule[idx][1]);
        } else {
            dfs(idx + schedule[idx][0], pay);
        }
        dfs(idx + 1, pay);
    }

}
