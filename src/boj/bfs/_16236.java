package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기상어
public class _16236 {

    static int N;

    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    static int sx, sy;
    static int size = 2;
    static int eat;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = cur;
                if (cur == 9) {
                    map[i][j] = 0;
                    sx = i; // 상어 위치
                    sy = j; // 상어 위치
                }
            }
        }

        while (true) {
            Fish fish = findFish();

            if (fish == null) {
                break;
            } else {
                map[fish.x][fish.y] = 0;
                eat++;
                sx = fish.x;
                sy = fish.y;
                answer += fish.dist;
                if (eat == size) {
                    eat = 0;
                    size++;
                }
            }
        }
        System.out.println(answer);
    }

    static Fish findFish() {
        PriorityQueue<Fish> pq = new PriorityQueue<>(); // 목표하는 먹이가 담기는 배열
        Queue<Fish> q = new LinkedList<>(); // bfs 탐색을 하기 위한 배열
        q.add(new Fish(sx, sy, 0)); // 초기값
        boolean visit[][] = new boolean[N][N]; // 방문 배열 (지나왔던 길)
        visit[sx][sy] = true;

        while (!q.isEmpty()) {
            Fish fish = q.poll();
            int x = fish.x;
            int y = fish.y;
            int dist = fish.dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 새로운 좌표 8방
                int ny = y + dy[i]; // 새로운 좌표

                if (nx >= 0 && ny >= 0 && nx < N && ny < N ) { // 전체 배열 범위 내부라면
                    if (!visit[nx][ny] && map[nx][ny] <= size) // 방문하지 않았고, 사이즈가 같거나 작으면
                    q.add(new Fish(nx, ny, dist + 1));
                    visit[nx][ny] = true;
                    if (map[nx][ny] < size && map[nx][ny] != 0) { // 사이즈가 0 이아니고 작으면 -> 먹을 수 있음
                        pq.add(new Fish(nx, ny, dist + 1)); // PriorityQueue 가 먹이가 담기는 배열 조건대로 정렬됨 // dist = 3 -> x, y 비교 -> 정렬
                    }
                }
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        return pq.poll();
    }
}
