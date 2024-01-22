package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숫자고르기
public class _2668 {

    static int N;

    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int start, int target) {
        int value = arr[start];

        if (arr[start] == target) {
            list.add(target);
            return;
        }

        if (visit[value] == false) {
            visit[value] = true;
            dfs(value, target);
            visit[value] = false;
        }
    }
}
