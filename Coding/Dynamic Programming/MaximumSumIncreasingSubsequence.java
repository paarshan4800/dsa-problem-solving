// Given an array arr of N positive integers, the task is to find the maximum
// sum increasing subsequence of the given array.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1#

// Input: N = 5, arr[] = {1, 101, 2, 3, 100}
// Output: 106
// Explanation:The maximum sum of a
// increasing sequence is obtained from
// {1, 2, 3, 100}

// LONGEST INCREASING SUBSEQUENCE - MODIFICATION

class Solution {
    public int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];
        int res = -1;

        // For a subproblem of length 1, the element is its own solution
        // Res will be the max of all the subproblems of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            res = Math.max(res, arr[i]);
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[j] > arr[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + arr[j]);
                    res = Math.max(res, dp[j]);
                }
            }
        }

        return res;
    }
}