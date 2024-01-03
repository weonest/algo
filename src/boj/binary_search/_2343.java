package boj.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 기타 레슨
public class _2343 {
    static int N, M;

    static int[] lecture;
    static int[] blue;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        lecture = new int[N];
        M = Integer.parseInt(st.nextToken());
        blue = new int[M];

        int sum = 0;
        int maxValue = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            sum += lecture[i];
            maxValue = Math.max(lecture[i], maxValue);
        }

        while (maxValue < sum) {
            int mid = (maxValue + sum) / 2;

            int count = 1;
            int tmp = mid;

            for (int i = 0; i < N; i++) {
                if (tmp < lecture[i]) {
                    tmp = mid;
                    count++;
                }
                tmp -= lecture[i];
            }
            if (count <= M) {
                sum = mid;
            } else {
                maxValue = mid + 1;
            }
        }
        System.out.println(maxValue);

    }
}
