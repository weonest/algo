package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 숫자 재배치
public class _16943 {

    static String A, B;

    static boolean[] visit;

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        if (A.length() > B.length()) {
            System.out.println(-1);
            return;
        }

        visit = new boolean[A.length()];
        backTracking(0, new StringBuilder());
        if (list.size() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(list.stream().map(Integer::parseInt).max(Integer::compareTo).get());
    }

    static void backTracking(int depth, StringBuilder sb) {
        if (depth == A.length()) {
            System.out.println(sb);
            if (Integer.valueOf(sb.toString()) < Integer.valueOf(B)) {
                if (sb.charAt(0) == '0') {
                    return;
                }
                list.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < A.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                sb.append(A.charAt(i));
                backTracking(depth + 1, sb);
                sb.setLength(sb.length() - 1);
                visit[i] = false;
            }
        }
    }
}
