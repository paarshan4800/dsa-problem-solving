// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

// Return the running sum of nums.

// Leetcode - https://leetcode.com/problems/running-sum-of-1d-array/

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]

// Input: nums = [1,1,1,1,1]
// Output: [1,2,3,4,5]

// Input: nums = [3,1,2,10,1]
// Output: [3,4,6,16,17]

class Solution {
    public int[] runningSum(int[] nums) {

        int[] res = new int[nums.length];
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] + res[i - 1];
        }

        return res;

    }
}