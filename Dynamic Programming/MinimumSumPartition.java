// Given an integer array arr of size N, the task is to divide it into two sets
// S1 and S2 such that the absolute difference between their sums is minimum and
// find the minimum difference

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/

// Input: N = 4, arr[] = {1, 6, 11, 5}
// Output: 1
// Explanation:
// Subset1 = {1, 5, 6}, sum of Subset1 = 12
// Subset2 = {11}, sum of Subset2 = 11

// Input: N = 2, arr[] = {1, 4}
// Output: 3
// Explanation:
// Subset1 = {1}, sum of Subset1 = 1
// Subset2 = {4}, sum of Subset2 = 4

class Solution {
    public int getSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        return sum;
    }

    public int minDifference(int arr[], int n) {
        int totalSum = getSum(arr);
        int reqSum = totalSum / 2;

        // Run 0-1 Knapsack for totalSum/2 as weight

        boolean[][] dp = new boolean[n + 1][reqSum + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int j = 1; j <= reqSum; j++)
            dp[0][j] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= reqSum; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }

        int res = Integer.MAX_VALUE;

        // For the last row each column
        for (int j = 0; j <= reqSum; j++) {
            // If partition possible, find the partition with minimum absolute difference
            if (dp[n][j])
                res = Math.min(res, totalSum - 2 * j);
        }

        return res;
    }
}
