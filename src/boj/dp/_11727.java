package boj.dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 2*n 타일링 2 (실버 3)
public class _11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10_007;
        }

        System.out.println(dp[n]);
    }
}
