package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class _14889 {

    static int N;
    static int[][] map;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(min);
    }

    static void comb(int idx, int cnt) {
        if (cnt == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                comb(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] == true && visit[j] == true) {
                    teamA += map[i][j];
                    teamA += map[j][i];
                }
                if (visit[i] == false && visit[j] == false) {
                    teamB += map[i][j];
                    teamB += map[j][i];
                }
            }
        }
        int result = Math.abs(teamA - teamB);

        if (result == 0) {
            min = result;
            return;
        }
        min = Math.min(result, min);
    }
}

