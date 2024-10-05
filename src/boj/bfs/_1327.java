package boj.bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 골드 4 소트 게임
public class _1327 {

    static Set<String> visit = new HashSet<>();
    static int N, K;
    static String input, goal;

    static class Node {
        String str;
        int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(st.nextToken());
        }
        input = sb.toString();

        sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
        }
        goal = sb.toString();
        System.out.println(bfs(input));
    }

    private static int bfs(String input) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(input, 0));
        visit.add(input);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.str.equals(goal)) return cur.cnt;

            for (int i = 0; i <= N - K; i++) {
                char[] c = cur.str.toCharArray();

                // 홀수면 가운데가 뒤집혀지지 않음
                // 인덱스를 옮겨가야 하기에 i + j
                for (int j = 0; j < K / 2; j++) {
                    char tmp = c[i + j];
                    c[i + j] = c[i + K - j - 1];
                    c[i + K - j - 1] = tmp;
                }

                String n = new String(c);
                if (!visit.contains(n)) {
                    visit.add(n);
                    q.offer(new Node(n, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}
