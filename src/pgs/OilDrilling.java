package pgs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class OilDrilling {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int[][] map;
    int n, m;
    int[] answer;

    public int solution(int[][] land) {

        map = land;
        n = land.length;
        m = land[0].length;
        answer = new int[m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j); // 000101
                }
            }
        }

        return Arrays.stream(answer).max().getAsInt();
    }

    private void bfs(int row, int col) {
        int size = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        map[row][col] = 2;

        Set<Integer> colSet = new HashSet<>();
        colSet.add(col);

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];

            for (int i = 0; i < 4; i++) {
                int nR = r + dx[i];
                int nC = c + dy[i];

                if (nR >= 0 && nC >= 0 && nR < n && nC < m) {
                    if (map[nR][nC] == 1) {
                        map[nR][nC] = 2;
                        q.add(new int[]{nR, nC});
                        size++;
                        colSet.add(nC);
                    }
                }
            }
        }
        for (int c : colSet) {
            answer[c] += size;
        }
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }

    public static void main(String[] args) {
        OilDrilling o = new OilDrilling();
        o.solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}});
    }
}
