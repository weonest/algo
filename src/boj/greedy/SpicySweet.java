package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SpicySweet {

    static int[] sumArr;
    static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sumArr = new int[n + 1];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
        }

        System.out.println(Arrays.toString(sumArr));

        //6
        //5 -5 6 0 2 -8
        for (int i = 0; i <= n; i++) {
            answer += map.getOrDefault(sumArr[i], 0);
            map.put(sumArr[i], map.getOrDefault(sumArr[i], 0) + 1);
        }

        System.out.println(answer);

    }
}
