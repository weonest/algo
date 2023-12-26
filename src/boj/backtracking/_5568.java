package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 카드 놓기
public class _5568 {

    static int N, K;

    static int[] cards;

    static boolean[] visit;

    static Set<Integer> set = new HashSet<>();

    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        visit = new boolean[N];
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        backTracking(0, new String[K]);
        System.out.println(set.size());

    }

    static void backTracking(int depth, String[] arr) {
        if (depth == K) {
            StringBuilder sb = new StringBuilder();
            for (String s : arr) {
                sb.append(s);
            }
            set.add(Integer.valueOf(sb.toString()));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = String.valueOf((cards[i]));
                backTracking(depth + 1, arr);
                visit[i] = false;
            }
        }

    }
}
