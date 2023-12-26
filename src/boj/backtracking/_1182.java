package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분수열의 합
public class _1182 {

    static int N, S;

    static int[] array;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        array = new int[N];

        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0) answer -= 1;
        System.out.println(answer);
    }

    static void dfs(int start, int sum) {
        if (start == N) {
            if (sum == S)
                answer++;
            return;
        }
        dfs(start + 1, sum);
        dfs(start + 1, sum + array[start]);
    }

}
