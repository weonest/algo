package pgs.dfs;

import java.util.List;

public class CoinMaker {

    static int answer;
    static int target;
    static List<Integer> list;

    public static void main(String[] args) {

        target = 5;
        int[] coins = new int[]{1, 2, 3};
        dfs(coins, 0, 0);

        System.out.println("answer = " + answer);

    }

    private static void dfs(int[] coins, int start, int sum) {
        if (target <= sum) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        for (int i = start; i < coins.length; i++) {
            dfs(coins, i, coins[i] + sum);
        }
    }
}
