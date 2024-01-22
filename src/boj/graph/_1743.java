package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 음식물 피하기
public class _1743 {
    static int N, M, K;


    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] map;
    static List<int[]> list = new ArrayList<>();

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N + 3][M + 3];
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            list.add(new int[]{row, col});

            map[row][col] = true;
        }

        for (int[] arr : list) {
            int r = arr[0];
            int c = arr[1];

            if (map[r][c]) {
                bfs(r, c);
            }
        }

        System.out.println(answer);
    }

    static void bfs(int r, int c) {
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        map[r][c] = false;

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int cR = arr[0];
            int cC = arr[1];

            for (int i = 0; i < 4; i++) {
                int nR = cR + dx[i];
                int nC = cC + dy[i];

                if (map[nR][nC]) {
                    map[nR][nC] = false;
                    cnt++;
                    q.add(new int[]{nR, nC});
                }
            }
        }
        answer = Math.max(answer, cnt);
    }

}
