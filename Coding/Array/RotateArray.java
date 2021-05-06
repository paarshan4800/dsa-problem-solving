// Given an array, rotate the array to the right by k steps, where k is non-negative.
// Leetcode - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/

// O(n) - Time Complexity
// O(n) - Space Complexity

// Use auxillary space to store values
// Iterate from size-k to size and store it in array
// And then iterate from beginning and store remaining

// O(n) - Time Complexity
// O(1) - Space Complexity

class Solution {

    // Reverse array
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {

        int size = nums.length;

        // Edge cases
        // If size of array one, remains the same
        if (size == 1) {
            return;
        }

        // If k>size, then using circular queue logic do k = k%size so that would be <
        // size
        if (k > size) {
            k = k % size;
        }

        int start = 0, end = nums.length - 1;

        // reverse the first part
        reverse(nums, start, end - k);
        // reverse the second part
        reverse(nums, end - k + 1, end);
        // reverse the whole array
        reverse(nums, start, end);

    }
}