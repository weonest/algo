package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 숫자 장자
public class _10597 {

    static int N;

    static List<Integer> nums = new ArrayList<>();

    static boolean[] visit = new boolean[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String seq = br.readLine();

        N = seq.length();

        if (N > 9) N -= (N - 9) / 2;

        backTracking(seq);
    }

    static void backTracking(String seq) {
        if (seq.equals("")) {
            for (int v : nums) {
                System.out.print(v + " ");
            }
            System.exit(0);
        }

        int num = 0;
        for (int i = 1; i <= 2; i++) {
            num = Integer.parseInt(seq.substring(0, i));
            if (num <= N && !visit[num]) {
                visit[num] = true;
                nums.add(num);
                backTracking(seq.substring(i));
                nums.remove(nums.size() - 1);
                visit[num] = false;
            }
        }
    }

}
