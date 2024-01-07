package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이와 가위
public class _20444 {

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long left = 0;
        long right = N;

        while (left <= right) {
            long row = (left + right) / 2;
            long col = N - row;

            long sum = (row + 1) * (col + 1);

            if (sum > K) {
                right = row - 1;
            } else if (sum < K) {
                left = row + 1;
            } else {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");

    }
}
