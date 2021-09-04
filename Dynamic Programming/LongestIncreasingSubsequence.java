// Given an integer array nums, return the length of the longest strictly
// increasing subsequence.

// A subsequence is a sequence that can be derived from an array by deleting
// some or no elements without changing the order of the remaining elements. For
// example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

// Leetcode - https://leetcode.com/problems/longest-increasing-subsequence/
// YouTube - https://www.youtube.com/watch?v=fV-TF4OvZpk

// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
// length is 4.

// Input: nums = [0,1,0,3,2,3]
// Output: 4

// Dynamic Programming - Bottom Up Approach
// Time Complexity - O(n^2)
// Space Complexity - O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1; // Default ans

        // Default ans is 1
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;

        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    // dp[j] = dp[j] --> current subsequence is a longer one
                    // dp[j] = dp[i] + 1 --> nums[j] extends the subsequence by 1
                    dp[j] = Math.max(dp[j], dp[i] + 1);

                    // Update res
                    res = Math.max(res, dp[j]);
                }
            }
        }

        return res;
    }
}