package boj.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int lo = 0;
        int hi = n - 1;
        int min = Integer.MAX_VALUE;
        int answerLo = lo;
        int answerHi = hi;

        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answerLo = lo;
                answerHi = hi;
                if (sum == 0) break;
            }
            if (sum < 0) lo++;
            else hi--;
        }
        System.out.println(arr[answerLo] + " " + arr[answerHi]);
    }
}
