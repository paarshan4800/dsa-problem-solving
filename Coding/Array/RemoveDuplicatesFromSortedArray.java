// Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
// Leetcode - https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/727/

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2]

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4]

// O(n) - Time Complexity
// O(1) - Space Complexity

class Solution {
    public int removeDuplicates(int[] nums) {

        // Index where change will happen. This will also maintain the count.
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            // nums[i] == nums[index] -> denotes that we have already come accross this
            // number so skip this iteration
            if (nums[i] == nums[index]) {
                continue;
            }

            // Update the next index with the new value
            nums[++index] = nums[i];
        }

        // index + 1 gives the length of distinct subarrauy
        return index + 1;

    }
}