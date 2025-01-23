import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 하노이의 탑
public class _11729 {

    static StringBuilder sb = new StringBuilder();
    static int moveCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        hanoi(n, "1", "2", "3");

        System.out.println(moveCnt);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, String start, String assist, String end) {
        if (n >= 1) {
            hanoi(n - 1, start, end, assist);
            sb.append(start + " " + end + "\n");
            moveCnt++;
            hanoi(n - 1, assist, start, end);
        }
    }
}
