package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _15686 {

    static int N, M;

    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> open = new ArrayList<>();

    static boolean[] visit;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
                if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }
        visit = new boolean[chicken.size()];

        backTracking(0, 0);

        System.out.println(answer);

    }

    static void backTracking(int start, int depth) {
        if (depth == M) {
            int result = 0;
            for (int[] h : house) {
                int dist = Integer.MAX_VALUE;
                for (int[] o : open) {
                    dist = Math.min(dist, Math.abs(h[0] - o[0]) + Math.abs(h[1] - o[1]));
                }
                result += dist;
            }
            answer = Math.min(answer, result);
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                open.add(chicken.get(i));
                backTracking(i + 1, depth + 1);
                open.remove(chicken.get(i));
                visit[i] = false;
            }
        }
    }
}
