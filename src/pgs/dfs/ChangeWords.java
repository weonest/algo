package pgs.dfs;

import java.util.*;


public class ChangeWords {

    boolean[] visit;
    int answer = 50;

    public int solution(String begin, String target, String[] words) {

        visit = new boolean[words.length];

        String sc = Arrays.stream(words)
                .filter(v -> v.equals(target))
                .findAny()
                .orElse(null);

        if (sc == null) return 0;

        dfs(begin, target, words, 0);

        if (answer == 50) return 0;

        return answer;
    }

    public void dfs(String tmp, String target, String[] words, int cnt) {
        if (tmp.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i]) {
                int k = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (tmp.charAt(j) == words[i].charAt(j)) k++;
                }
                // 2개가 일치 하는 경우
                if (k == tmp.length() - 1) {
                    visit[i] = true;
                    dfs(words[i], target, words, cnt + 1);
                    visit[i] = false;
                }
            }
        }
    }

    static class Node {
        String cur;
        int cnt;

        public Node(String cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }

    public void bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        boolean[] visit = new boolean[words.length];

        while (!q.isEmpty()) {
            Node node = q.poll();
            String cur = node.cur;
            int cnt = node.cnt;

            if (cur.equals(target)) {
                answer = cnt;
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visit[i]) {
                    int k = 0;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (cur.charAt(j) == words[i].charAt(j)) k++;
                    }
                    if (k == cur.length() - 1) {
                        q.offer(new Node(words[i], cnt + 1));
                    }
                }
            }
            answer = cnt;
        }
    }
}
