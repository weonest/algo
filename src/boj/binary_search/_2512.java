package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 예산
public class _2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] budget = new int[n];

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            right = Math.max(budget[i], right);
        }
        Arrays.sort(budget);

        int m = Integer.parseInt(br.readLine());

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (budget[i] > mid) sum += mid;
                else sum += budget[i];
            }

            if (sum <= m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
