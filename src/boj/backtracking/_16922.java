package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 로마 숫자
public class _16922 {

    static int N;

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        comb(0, 0, new StringBuilder());

        System.out.println(set.size());
    }

    static void comb(int start, int depth, StringBuilder sb) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < sb.length(); i++) {
                char cur = sb.charAt(i);
                if (cur == '0') {
                    sum += 1;
                }
                if (cur == '1') {
                    sum += 5;
                }
                if (cur == '2') {
                    sum += 10;
                }
                if (cur == '3') {
                    sum += 50;
                }

            }
            set.add(sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            sb.append(i);
            comb(i, depth + 1, sb);
            sb.setLength(sb.length() - 1);
        }

    }
}
