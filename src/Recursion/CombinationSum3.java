package Recursion;

import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();

        backTrack(nums, 0, k, n, result, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int start, int k, int n, List<List<Integer>> result, List<Integer> current) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (k == 0 || n < 0)
            return;

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);
            backTrack(nums, i + 1, k-1, n - nums[i], result, current);
            current.remove(current.size() -1 );
        }
    }
}
