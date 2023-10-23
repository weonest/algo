package boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 문제 추천 시스템 Version 1
public class _21939 {

    static int N;
    static int M;

    static class Problem implements Comparable<Problem>{
        int p, l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }

        // 난이도 낮은 순, 문제번호 낮은 순
        @Override
        public int compareTo(Problem o) {
            if (this.l != o.l) {
                return this.l - o.l;
            } else {
                return this.p - o.p;
            }
        }

    }

    static Map<Integer, Problem> map = new HashMap<>();
    // 맨 앞과 맨 뒤를 가져오기 위해 TreeSet 사용
    static TreeSet<Problem> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(p, l);
            map.put(p, problem);
            set.add(problem);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                add(p, l);
                continue;
            }
            if (command.equals("recommend")) {
                int option = Integer.parseInt(st.nextToken());
                recommend(option);
                continue;
            }
            if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                solve(p);
            }

        }
    }

    private static void solve(int p) {
        Problem problem = map.remove(p);
        set.remove(problem);
    }

    private static void recommend(int option) {
        if (option == 1) {
            System.out.println(set.last().p);
        }else {
            System.out.println(set.first().p);
        }
    }

    private static void add(int p, int l) {
        Problem problem = new Problem(p, l);
        map.put(p, problem);
        set.add(problem);
    }

}
