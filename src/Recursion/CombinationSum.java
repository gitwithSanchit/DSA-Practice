package Recursion;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(candidates, target, 0, current, result);
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);

            backTrack(candidates, target - candidates[i], i, current, result);

            current.remove(current.size() - 1);
        }
    }
}
