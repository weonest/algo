package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뻔데기
public class _15721 {

    static int N;
    static int T;
    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());

        System.out.println(solution());

    }

    static int solution() {
        int repeat = 2;
        int bbun = 0;
        int degi = 0;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    bbun++;
                } else {
                    degi++;
                }

                if (bbun == T && R == 0) {
                    return (bbun + degi - 1) % N;
                }

                if (degi == T && R == 1) {
                    return (bbun + degi - 1) % N;
                }
            }

            for (int i = 0; i < repeat; i++) {
                bbun++;
                if (bbun == T && R == 0) {
                    return (bbun + degi - 1) % N;
                }
            }

            for (int i = 0; i < repeat; i++) {
                degi++;
                if (degi == T && R == 1) {
                    return (bbun + degi - 1) % N;
                }
            }
            repeat++;
        }
    }
}
