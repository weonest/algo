package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 용액
public class _2473 {

    static int N;

    static int[] liquid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        liquid = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int answer[] = new int[3];
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int mid = i + 1;
            int right = N - 1;

            while (mid < right) {
                long sum = (long) liquid[i] + liquid[mid] + liquid[right];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = liquid[i];
                    answer[1] = liquid[mid];
                    answer[2] = liquid[right];
                }
                if (sum == 0) break;
                if (sum > 0) {
                    right--;
                }
                if (sum < 0) {
                    mid++;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}

// 1, 2, 23, 44, 52