package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {

    static int T;

    static int side;

    static class Position {
        int x;
        int y;
        int tX;
        int tY;
        int cnt;

        public Position(int x, int y, int tX, int tY, int cnt) {
            this.x = x;
            this.y = y;
            this.tX = tX;
            this.tY = tY;
            this.cnt = cnt;
        }
    }

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static boolean[][] visisted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            side = Integer.parseInt(br.readLine());
            visisted = new boolean[side + 1][side + 1];

            st = new StringTokenizer(br.readLine());
            int initX = Integer.parseInt(st.nextToken());
            int initY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            Position pos = new Position(initX, initY, targetX, targetY, 0);

            bfs(pos);
        }
    }

    static void bfs(Position pos) {
        Queue<Position> q = new ArrayDeque<>();
        q.add(pos);
        visisted[pos.x][pos.y] = true;

        while (!q.isEmpty()) {
            Position p = q.poll();
            int curX = p.x;
            int curY = p.y;
            int tX = p.tX;
            int tY = p.tY;
            int cnt = p.cnt;

            if (curX == tX && curY == tY) {
                System.out.println(cnt);
            }

            for (int i = 0; i < 8; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];

                if (nX < 0 || nY < 0 || nX > side - 1 || nY > side - 1) continue;

                if (!visisted[nX][nY]) {
                    q.add(new Position(nX, nY, tX, tY, cnt + 1));
                    visisted[nX][nY] = true;
                }
            }
        }
    }
}
