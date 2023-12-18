package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
public class _14502 {

    static int N;
    static int M;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            spread();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 객체는 주소값을 가지고 있기 때문에 clone()을 쓰면 얕은 복사
    static void spread() {
        int[][] lab = new int[N][M];
        for (int i = 0; i < map.length; i++) {
            lab[i] = map[i].clone();
        }

        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    que.add(new int[]{i, j});
                }
            }
        }

        while (!que.isEmpty()) {
            int x = que.peek()[0];
            int y = que.poll()[1];

            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
                    if (lab[nX][nY] == 0) {
                        lab[nX][nY] = 2;
                        que.add(new int[]{nX, nY});
                    }
                }
            }
        }
        calculateSafeZone(lab);
    }

    static void calculateSafeZone(int[][] lab) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        if (answer < safeZone) {
            answer = safeZone;
        }
    }

}
