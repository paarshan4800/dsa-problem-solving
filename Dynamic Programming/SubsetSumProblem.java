// Given an array of non-negative integers, and a value sum, determine if there
// is a subset of the given set with sum equal to given sum.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/

// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 9
// Output: 1
// Explanation: Here there exists a subset with
// sum = 9, 4+3+2 = 9.

// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 30
// Output: 0
// Explanation: There is no subset with sum 30.

// Time Complexity - O(n*sum)
// Space Complexity - O(n*sum)
class Solution {

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];

        // i, row -> no. of elements in the subset
        // j, column -> sum

        // For sum = 0, we can exclude all elements in each subset
        for (int i = 0; i <= N; i++)
            dp[i][0] = true;

        // For subset of size 0, the sum will always be 0
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                // If an element is greater than the current sum, then we can't include it
                // So the result would be the subproblem excluding it i.e dp[i-1][j]
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                // If an element is less than or equal to the current sum, then we may or may
                // not include it.
                // dp[i-1][j] = not including it
                // dp[i - 1][j - arr[i - 1]] = including it
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[N][sum];
    }
}