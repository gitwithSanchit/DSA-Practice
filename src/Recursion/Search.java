package Recursion;

public class Search {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    private int search(int[] nums, int target, int s, int e) {

        if(s > e){
            return -1;
        }

        int mid = s + (e - s)/2;

        if (nums[mid] == target)
            return mid;

        return (nums[mid] < target) ? search(nums, target, mid + 1, e) : search(nums, target, s, mid - 1);
    }
}
