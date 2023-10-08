package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9328 {

    static int T, H, W;

    static char[][] map;

    static boolean[][][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[] key;

    static class Node {
        int x;
        int y;
        int keys;

        public Node(int x, int y, int keys) {
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int answer;
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 한 번 감싸주지 않으면 되돌아가지 못한다.
            map = new char[H + 2][W + 2];
            // 왜 열쇠 배열이 +2 여야 가능할까?
            visited = new boolean[H + 2][W + 2][26+2];
            key = new boolean[26];

            for (int i = 0; i < H + 2; i++) {
                for (int j = 0; j < W + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= H; i++) {
                String floor = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = floor.charAt(j - 1);
                }
            }

            String keys = br.readLine();
            int keyCnt = keys.length();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    int idx = keys.charAt(i) - 'a';
                    key[idx] = true;
                }
            }
            bfs(keyCnt);
        }

    }

    static void bfs(int keyCnt) {
        int answer = 0;
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.keys - o2.keys);
        q.add(new Node(0, 0, keyCnt));
        visited[0][0][keyCnt] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int keys = cur.keys;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= W + 2 || ny >= H + 2) continue;

                if (!visited[ny][nx][keys] && map[ny][nx] != '*') {
                    if (map[ny][nx] - 'A' >= 0 && map[ny][nx] - 'A' <= 25) {
                        if (key[map[ny][nx] - 'A']) {
                            map[ny][nx] = '.';
                            q.add(new Node(nx, ny, keys));
                            visited[ny][nx][keys] = true;
                        }
                    }

                    else if (map[ny][nx] - 'a' >= 0 && map[ny][nx] - 'a' <= 25) {
                        key[map[ny][nx] - 'a'] = true;
                        map[ny][nx] = '.';
                        keys++;
                        q.add(new Node(nx, ny, keys));
                        visited[ny][nx][keys] = true;
                    }

                    else if (map[ny][nx] == '.') {
                        q.add(new Node(nx, ny, keys));
                        visited[ny][nx][keys] = true;
                    }

                    else if (map[ny][nx] == '$') {
                        answer++;
                        map[ny][nx] = '.';
                        q.add(new Node(nx, ny, keys));
                    }
                }
            }

        }
        System.out.println(answer);
    }



}
