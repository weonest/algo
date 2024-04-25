package pgs.binary_search;

import java.util.Arrays;

// 숫자게임
public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;    // A idx
        for (int i = 0; i < B.length; i++) {
            if (A[cnt] < B[i]) {
                answer++;
                cnt++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        NumberGame n = new NumberGame();
        n.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8});
    }
}
