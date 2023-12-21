package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2503 {

    static int N;

    static List<Integer> round = new ArrayList<>();
    static List<int[]> result = new ArrayList<>();

    static boolean[] visit = new boolean[10];

    static int answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            round.add(number);
            result.add(new int[]{strike, ball});
        }

        dfs(0, new StringBuilder());

        System.out.println(answer);

    }

    static void dfs(int depth, StringBuilder sb) {
        if (depth == 3) {
            int num = Integer.valueOf(sb.toString());
            if (check(num)) {
                answer++;
                return;
            }

        }

        for (int i = 1; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                sb.append(i);
                dfs(depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
                visit[i] = false;
            }
        }
    }

    static boolean check(int num) {
        int a = num / 100;
        int b = num / 10 - (a * 10);
        int c = num % 10;
        for (int i = 0; i < N; i++) {
            int st = 0, bt = 0;
            int base = round.get(i);
            int baseSt = result.get(i)[0];
            int baseBt = result.get(i)[1];

            int ba = base / 100;
            int bb = base / 10 - (ba * 10);
            int bc = base % 10;

            if (a == ba) st++;
            if (b == bb) st++;
            if (c == bc) st++;

            if (a == bb || a == bc) bt++;
            if (b == ba || b == bc) bt++;
            if (c == ba || c == bb) bt++;

            if (st != baseSt || bt != baseBt) {
                return false;
            }
        }
        return true;
    }

}
