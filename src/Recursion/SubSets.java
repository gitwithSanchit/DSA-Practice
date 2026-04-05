package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backTrack(nums, result, current, 0);
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> current, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        //Take
        current.add(nums[index]);
        backTrack(nums, result, current, index + 1);

        //Undo(Backtrack)
        current.remove(current.size() - 1);

        //Not take
        backTrack(nums, result, current, index + 1);
    }
}
