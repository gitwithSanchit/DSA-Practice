package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backTrack(nums, new ArrayList<>(), 0, result);
        return result;
    }

    private void backTrack(int[] nums, List<Integer> current, int index, List<List<Integer>> result) {
        //At every step add in the list
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++ ) {
            //skip the duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            //Take
            current.add(nums[i]);

            backTrack(nums, current, index + 1, result);

            //Undo
            current.remove(current.size() - 1);
        }
    }
}
