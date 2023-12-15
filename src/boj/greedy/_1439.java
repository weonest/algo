package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String n = br.readLine();
        StringTokenizer s1 = new StringTokenizer(n, "0");
        StringTokenizer s0 = new StringTokenizer(n, "1");

        System.out.println(Math.min(s1.countTokens(), s0.countTokens()));


//        char pre = n.charAt(0);
//        int zeroCnt = 0, oneCnt = 0;
//
//        if (pre == '0') {
//            zeroCnt++;
//        }else {
//            oneCnt++;
//        }
//
//        for (int i = 1; i < n.length(); i++) {
//            char cur = n.charAt(i);
//
//            if (pre != cur) {
//                if (cur == '0') {
//                    zeroCnt++;
//                }else {
//                    oneCnt++;
//                }
//            }
//            pre = cur;
//        }
//
//        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
