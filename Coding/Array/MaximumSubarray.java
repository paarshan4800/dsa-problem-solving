// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// Leetcode - https://leetcode.com/problems/maximum-subarray/
// GeeksForGeeks - Must do questions topic wise

// O(n) - Time Complexity
// O(n) - Space Complexity
class Solution1 {
    public int maxSubArray(int[] nums) {
        // Dynamic Programming Approach
        int[] dp = new int[nums.length];

        // First element has no extension. It is the start of a new sub array
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // dp[i] = nums[i] -> denotes that this is the start of new sub array
            // dp[i] = nums[i] + dp[i-1] -> denotes that this is the extension of previous
            // sub array
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        // Traverse through the dp array. The max value is the sum of maximum subarray
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

// O(n) - Time Complexity
// O(1) - Space Complexity
class Solution2 {
    public int maxSubArray(int[] nums) {

        // Space Optimization of previous solution.
        // Instead of finding the max value from the dp array,
        // we keep track of the maximum value during traversal

        // First element has no extension. It is the start of a new sub array
        int res = nums[0];
        int val = res;

        for (int i = 1; i < nums.length; i++) {
            // dp[i] = nums[i] -> denotes that this is the start of new sub array
            // dp[i] = nums[i] + val -> denotes that this is the extension of previous
            // sub array
            val = Math.max(nums[i], nums[i] + val);
            // If val > res i.e sum of maximum subarray occured so far, update it
            res = Math.max(res, val);
        }

        return res;
    }
}