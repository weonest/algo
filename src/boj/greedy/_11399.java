package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11399 {
    
    static int N;

    static int[] line;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        line = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line);

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = dp[0] + line[0];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + line[i - 1];
        }

        System.out.println(Arrays.stream(dp).sum());
    }

}
