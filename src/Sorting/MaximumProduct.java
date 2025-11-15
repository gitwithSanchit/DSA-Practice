package Sorting;

import java.util.Arrays;

public class MaximumProduct {

    //TC : O(NlogN)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int product1 = nums[n- 1]*nums[n-2]*nums[n-3];
        int product2 = nums[0]*nums[1]*nums[n-1];
        return Math.max(product1, product2);
    }

    //TC : O(N)
    public int maximumProduct1(int[] nums) {
        // Track top 3 max values
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        // Track bottom 2 min values
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int n : nums) {

            // Update maxes
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            // Update mins
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }

        int prod1 = max1 * max2 * max3;
        int prod2 = min1 * min2 * max1;

        return Math.max(prod1, prod2);
    }

}
