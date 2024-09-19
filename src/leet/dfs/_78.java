package leet.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Subsets
public class _78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsetsComb(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        if (nums.length == 1) {
            answer.add(Arrays.stream(nums).boxed().toList());
            return answer;
        }

        for (int num: nums) {
            int size = answer.size();

            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(answer.get(i));
                newList.add(num);
                answer.add(newList);
            }
        }
        return answer;
    }

    public static List<List<Integer>> subsetsComb(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        comb(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    // O(2^N)
    public static void comb(List<List<Integer>> answer, List<Integer> list, int[] nums, int start) {
        answer.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            comb(answer, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
