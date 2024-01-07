package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 보석 상자
public class _2792 {

    static int N, M;

    static int[] jewel;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        jewel = new int[M];

        int min = 1;
        int max = 0;

        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            max = Math.max(jewel[i], max);
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            int count = 0;
            for (int i = 0; i < M; i++) {
                count += jewel[i] / mid;
                if (jewel[i] % mid != 0) {
                    count++;
                }
            }

            if (count <= N) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(answer);
    }
}
