package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int closest = 0;
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i+ 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                int currentDiff = Math.abs(target - sum);

                if (currentDiff < diff) {
                    diff = currentDiff;
                    closest = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }
}
