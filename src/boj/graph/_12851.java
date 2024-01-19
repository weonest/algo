package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질2
public class _12851 {

    static int N, K;
    static int[] time = new int[100_001];
    static int min = Integer.MAX_VALUE;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }
        bfs();
        System.out.println(min);
        System.out.println(answer);
    }

    static void bfs() {
        Queue <Integer> q = new ArrayDeque<>();
        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (min < time[cur]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if (i == 0) {
                    next = cur + 1;
                }
                if (i == 1) {
                    next = cur - 1;
                }
                if (i == 2) {
                    next = cur * 2;
                }

                if (next < 0 || next > 100_000) continue;

                if (next == K) {
                    min = time[cur];
                    answer++;
                }

                if (time[next] == 0 || time[next] == time[cur] + 1) {
                    q.add(next);
                    time[next] = time[cur] + 1;
                }
            }
        }
    }
}
