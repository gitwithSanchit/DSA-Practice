package Sorting;

public class InPlace {
    public void sortColors1(int[] nums) {
        boolean swapped;

        for (int i = 0; i < nums.length - 1; i++) {
            swapped = false;

            for (int j = 1;j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j -1];
                    nums[j-1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                return;
        }
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            }else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
