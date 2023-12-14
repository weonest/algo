package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기적의 매매법
public class _20546 {

    static int[] market = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int asset = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            market[i] = Integer.parseInt(st.nextToken());
        }

        int bnp = bnp(asset);
        int timing = timing(asset);

        if (bnp > timing) {
            System.out.println("BNP");
        } else if (bnp == timing) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }
    }

    static int bnp(int asset) {
        int stockCnt = 0;

        for (int i = 0; i < 14; i++) {
            int cur = market[i];

            if (cur > asset) {
                continue;
            }

            while (asset > 0) {
                asset -= cur;
                stockCnt++;
            }
        }
        return market[13] * stockCnt + asset;
    }

    static int timing(int asset) {
        int stockCnt = 0;

        int downCnt = 0;
        int upCnt = 0;

        int tmp = market[0];

        for (int i = 1; i < 14; i++) {
            int cur = market[i];

            if (cur < tmp) {
                downCnt++;
                upCnt = 0;
            }
            if (cur > tmp) {
                upCnt++;
                downCnt = 0;
            }
            if (upCnt >= 3) {
                asset += stockCnt * market[i];
                stockCnt = 0;
            }
            if (downCnt >= 3) {
                while (asset >= cur) {
                    asset -= cur;
                    stockCnt++;
                }
            }
            tmp = cur;
        }
        return asset + stockCnt * market[13];
    }
}
