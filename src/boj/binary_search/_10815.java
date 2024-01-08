package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자 카드
public class _10815 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int target = Integer.parseInt(st.nextToken());
            boolean flag = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (target < cards[mid]) {
                    right = mid - 1;
                    continue;
                }
                if (target > cards[mid]) {
                    left = mid + 1;
                    continue;
                }
                if (target == cards[mid]) {
                    flag = true;
                    break;
                }
            }
            if (flag) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
