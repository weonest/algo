package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ZOAC3
public class _20436 {

    static char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'X'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm', 'X', 'X', 'X'}};

    static char initLeft;
    static char initRight;

    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        initLeft = st.nextToken().charAt(0);
        initRight = st.nextToken().charAt(0);

        String target = br.readLine();

        int[] leftPos = findPosition(initLeft);
        int[] rightPos = findPosition(initRight);
        for (int i = 0; i < target.length(); i++) {
            char cur = target.charAt(i);
            int[] curPos = findPosition(cur);

            if (cur == 'q' || cur == 'w' || cur == 'e' || cur == 'r' || cur == 't' || cur == 'a' || cur == 's' || cur == 'd' || cur == 'f' ||
                cur == 'g' || cur == 'z' || cur == 'x' || cur == 'c' || cur == 'v') {
                time += Math.abs(leftPos[0] - curPos[0]) + Math.abs(leftPos[1] - curPos[1]) + 1;
                leftPos = curPos;
            } else {
                time += Math.abs(rightPos[0] - curPos[0]) + Math.abs(rightPos[1] - curPos[1]) + 1;
                rightPos = curPos;
            }

        }

        System.out.println(time);
    }

    static int[] findPosition(char c) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (keyboard[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
