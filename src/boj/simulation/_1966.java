package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐
public class _1966 {

    static int T;
    static int N;
    static int IDX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            Queue<int[]> printer = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int[] answer = new int[N];
            IDX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                printer.offer(new int[]{i, Integer.valueOf(st.nextToken())});
            }

            int max = printer.stream().map(v-> v[1]).max(Integer::compareTo).get();
            int order = 1;
            while (!printer.isEmpty()) {
                int[] doc = printer.peek();
                int idx = doc[0];
                int imp = doc[1];

                if (imp == max) {
                    printer.poll();
                    answer[idx] = order;
                    order++;
                    max = printer.stream().map(v-> v[1]).max(Integer::compareTo).orElse(0);
                    continue;
                }

                printer.offer(printer.poll());

            }
            System.out.println(answer[IDX]);
        }


    }
}
