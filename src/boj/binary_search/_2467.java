package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 용액
public class _2467 {

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

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int answer[] = new int[2];
        while (left < right) {
            int sum = liquid[left] + liquid[right];
            if (Math.abs(sum) <= Math.abs(min)) {
                min = sum;
                answer[0] = liquid[left];
                answer[1] = liquid[right];
            }
            if (sum == 0) break;
            if (sum > 0) {
                right--;
            }
            if (sum < 0) {
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}

// 1, 2, 23, 44, 52