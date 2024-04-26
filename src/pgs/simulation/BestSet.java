package pgs.simulation;

// 최고의 집합
public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (s < n) return new int[] {-1};

        int idx = 0;
        while(idx < n) {
            int v = s / (n - idx);
            s -= v;
            answer[idx++] = v;
        }
        return answer;
    }
}
