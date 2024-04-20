package pgs;

public class NQueen {
    int[] map;
    int answer = 0;

    public int solution(int n) {

        map = new int[n];

        back(n, 0);

        return answer;
    }

    public void back(int n, int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            map[row] = i;
            if (possible(row)) {
                back(n, row + 1);
            }
        }
    }

    public boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            if (map[i] == map[row]) return false;
            if (Math.abs(row - i) == Math.abs(map[row] - map[i])) return false;
        }
        return true;
    }
}
