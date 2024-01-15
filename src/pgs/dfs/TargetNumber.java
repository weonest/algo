package pgs.dfs;

public class TargetNumber {
    int answer = 0;
    int[] numbers;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        return answer;
    }

    private void dfs(int idx, int sum, int target) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(idx + 1, sum + numbers[idx], target);
        dfs(idx + 1, sum - numbers[idx], target);
    }

}
