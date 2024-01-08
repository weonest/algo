package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1654 {

    // 랜선 자르기
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] lans = new int[N];

        long max = 0;
        for (int i = 0; i < N; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lans[i]);
        }

        long left = 1;
        long right = max;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long count = 0;

            for (int i = 0; i < lans.length; i++) {
                count += lans[i] / mid;
            }

            if (count < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
