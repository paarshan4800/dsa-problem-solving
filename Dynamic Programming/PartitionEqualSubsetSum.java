// Given an array arr[] of size N, check if it can be partitioned into two parts
// such that the sum of elements in both parts is the same.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#

// Input: N = 4
// arr = {1, 5, 11, 5}
// Output: YES
// Explaination:
// The two parts are {1, 5, 5} and {11}.

// For Input:
// 4
// 1 2 3 5

// Your Output is:
// NO

class Solution {

    static int getSum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        return sum;
    }

    static int equalPartition(int N, int arr[]) {
        int sum = getSum(arr);

        // Since the two sets should have the same sum, the sum of those two sets (i.e
        // the sum of all elements in the given array) should be even
        if (sum % 2 != 0)
            return 0;

        // Target is the sum of all elements in one set
        int target = sum / 2;

        // If we find that the elements given fall in one subset, then the remaining
        // elements will definitely fall in the another one

        // So find whether the given elements form a subset sum for the target
        boolean[][] dp = new boolean[N + 1][target + 1];

        for (int i = 0; i <= N; i++)
            dp[i][0] = true;

        for (int i = 1; i <= target; i++)
            dp[0][i] = false;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[N][target] ? 1 : 0;
    }
}