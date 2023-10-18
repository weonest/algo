package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 소문난 칠공주 문제
public class _1941 {

    static char[][] map = new char[5][5];
    static int answer;
    static int[] selected = new int[7];
    // 5 x 5 좌표를 탐색하기 위한 dx, dy
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        comb(0, 0);
        System.out.println(answer);

    }

    static void comb(int start, int depth) {
        if (depth == 7) {
            if (check()) answer++;
            return;
        }

        // 조합에는 방문배열이 필요가 없다
        for (int i = start; i < 25; i++) {
                selected[depth] = i;
                comb(i + 1, depth + 1);
        }
    }

    static boolean check() {
        int Y = 0;
        for (int val : selected) {
            if (map[val / 5][val % 5] == 'Y') Y++;
        }
        if (Y > 3) return false;

        Deque<Integer> q = new ArrayDeque<>();
        q.add(selected[0]);
        List<Integer> princess = Arrays.stream(selected).boxed().collect(Collectors.toList());
        while (!q.isEmpty()) {
            int girl = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = girl / 5 + dx[i];
                int ny = girl % 5 + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    if (princess.contains(nx * 5 + ny)) {
                        princess.remove(Integer.valueOf(nx * 5 + ny)); // 인덱스가 아닌 요소르 직접 삭제하기 위해 Integer.valueOf 사용
                        q.offer(nx * 5 + ny);
                    }
                }
            }

        }
        if (!princess.isEmpty()) return false;
        return true;
    }
}
