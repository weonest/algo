package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 휴게소 세우기
public class _1477 {

    static int N, M, L;

    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        pos = new int[N + 2];
        pos[0] = 0;
        pos[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < pos.length; i++) {
                count += (pos[i] - pos[i - 1] - 1) / mid;
            }

            if (count <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }



}
