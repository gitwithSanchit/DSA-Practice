package Recursion;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        CombinationSum2 sol = new CombinationSum2();
        List<List<Integer>> result = sol.combinationSum2(candidates, target);

        System.out.println("\nFinal Answer:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);  // important
        System.out.println("Sorted Array: " + Arrays.toString(candidates));

        backtrack(candidates, target, 0, current, result);

        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        System.out.println("Called -> target: " + target +
                ", index: " + index +
                ", current: " + current);

        if (target == 0) {
            System.out.println("Found combination: " + current);
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicates
            if (i > index && candidates[i] == candidates[i - 1]) {
                System.out.println("Skipping duplicate: " + candidates[i]);
                continue;
            }

            current.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i + 1, current, result);

            current.remove(current.size() - 1);  // backtrack
        }
    }
}