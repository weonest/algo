package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {

    static int N, M;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int num = Integer.parseInt(st.nextToken());
            boolean flag = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (num < arr[mid]) {
                    right = mid - 1;
                }
                if (num > arr[mid]){
                    left = mid + 1;
                }
                if (num == arr[mid]) {
                    flag = true;
                    break;
                }
            }
            if (flag) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
