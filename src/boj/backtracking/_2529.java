package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 부등호
public class _2529 {

    static int K;

    static char[] sign;

    static boolean[] visit;

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        sign = new char[K];
        visit = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        backTracking(0, new int[K + 1]);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void backTracking(int depth, int[] arr) {
        if (depth == K + 1) {
            int temp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int cur = arr[i];
                char c = sign[i - 1];
                if (c == '<') {
                    if (temp < cur) {
                        temp = cur;
                        continue;
                    }
                }
                if (c == '>') {
                    if (temp > cur) {
                        temp = cur;
                        continue;
                    }
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n);
            }
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                backTracking(depth + 1, arr);
                visit[i] = false;
            }
        }
    }
}
