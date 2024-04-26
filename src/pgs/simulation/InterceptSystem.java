package pgs.simulation;

import java.util.Arrays;

public class InterceptSystem {

    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int cur = 0;

        for (int[] arr : targets) {
            if (cur <= arr[0]) {
                cur = arr[1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        InterceptSystem s = new InterceptSystem();
        s.solution(new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}});
    }
}
