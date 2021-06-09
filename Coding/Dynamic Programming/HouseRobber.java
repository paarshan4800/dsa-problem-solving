// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Leetcode - https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/

// Input: nums = [1,2,3,1]
// Output: 4

// Input: nums = [2,7,9,3,1]
// Output: 12

// Dynamic Programming - Bottom Up Approach
// Time Complexity - O(n)
class Solution {
    public int rob(int[] nums) {

        // If only one house, can only rob that
        if (nums.length == 1) {
            return nums[0];
        }

        // Tabulation for Bottom Up
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; // If 0 houses, cant rob anything
        dp[1] = nums[0]; // If only one house, can only rob that

        for (int i = 1; i < nums.length; i++) {
            // dp[i+1] = dp[i] ---> not robbing nums[i].
            // dp[i+1] = dp[i-1] + nums[i] ---> robbing nums[i] yields a better solution. So
            // we leave out the previous home (i-1)
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[nums.length];

    }
}