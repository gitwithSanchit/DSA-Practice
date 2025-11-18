package Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {

    //Time complexity : O((N + k)logN)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = maxHeap.poll();
        }

        return ans;
    }

    //Time complexity : O(NlogN)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {

            if (minHeap.size() < k) {
                minHeap.add(num);
            }else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }

    //Time complexity : O(N)
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        int targetIndex = n - k; // convert kth largest → index in sorted array
        return quickSelect(nums, 0, n - 1, targetIndex);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        while (true) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == k) {
                return nums[pivotIndex];
            }
            else if (pivotIndex < k) {
                left = pivotIndex + 1;
            }
            else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
