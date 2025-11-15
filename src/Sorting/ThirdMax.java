package Sorting;

import java.util.Arrays;

public class ThirdMax {

    //Time complexity : O(NlogN)
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int distinctCount = 0;
        int prev = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i <= 0; i--){
            if (nums[i] != prev) {
                distinctCount++;
                prev = nums[i];
                if (distinctCount == 3) return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    //Time complexity : O(N)
    public int thirdMax1(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third =  Long.MIN_VALUE;

        for (int n : nums) {
            if (n < third) {
                continue;
            } else if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n < first && n > second) {
                third = second;
                second = n;
            } else if (n < second && n > third) {
                third = n;
            }
        }
        return Math.toIntExact(third == Long.MIN_VALUE ? first : third);

    }
}
