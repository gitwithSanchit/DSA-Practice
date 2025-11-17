package Sorting;

import java.util.HashMap;
import java.util.logging.Handler;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for (int n : nums) {
            if (n % 2 == 0) {
                result[left++] = n;
            }else {
                result[right--] = n;
            }
        }

        return result;
    }
}
