package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암기왕
public class _2776 {

    static int T, N, M;

    static int[] note1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(br.readLine());
            note1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int cur = Integer.parseInt(st.nextToken());
                boolean flag = false;
                int left = 0, right = N - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (cur < note1[mid]) {
                        right = mid - 1;
                        continue;
                    }
                    if (cur > note1[mid]) {
                        left = mid + 1;
                        continue;
                    }
                    if (cur == note1[mid]) {
                        flag = true;
                        break;
                    }
                }
                sb.append(flag ? 1 : 0).append("\n");
            }
            System.out.println(sb);
        }
    }
}
