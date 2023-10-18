package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16987 {

    static Egg[] eggs;

    static class Egg {
        int dura;
        int weight;

        public Egg(int dura, int weight) {
            this.dura = dura;
            this.weight = weight;
        }
    }

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dura = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(dura, weight);
        }

        backTracking(0, 0);
        System.out.println(answer);
    }

    static void backTracking(int target, int cnt) {
        if (target == N) { // 조건 3번 가장 오른쪽일때 종료
            answer = Math.max(answer, cnt);
            return;
        }

        // 타겟 계란 (현재 들고 있는 계란 x) 이 깨져있거나, 현재 계란 + 타겟 계란이 모두 깨진 경우 pass
        if (eggs[target].dura <= 0 || cnt == N - 1) {
            backTracking(target + 1, cnt);
            return;
        }

        int nCnt = cnt;

        for (int i = 0; i < N; i++) {
            if (i == target) continue;

            if (eggs[i].dura <= 0) continue;

            eggs[i].dura -= eggs[target].weight;
            eggs[target].dura -= eggs[i].weight;

            if (eggs[target].dura <= 0) cnt++;

            if (eggs[i].dura <= 0) cnt++;

            backTracking(target + 1, cnt);

            eggs[i].dura += eggs[target].weight;
            eggs[target].dura += eggs[i].weight;

            cnt = nCnt;
        }
    }
}
