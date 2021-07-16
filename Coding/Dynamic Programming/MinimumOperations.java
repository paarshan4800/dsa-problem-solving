// Given a number N. Find the minimum number of operations required to reach N
// starting from 0. You have 2 operations available:

// Double the number
// Add one to the number

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-optimum-operation4504/1#

// Input:
// N = 8
// Output: 4
// Explanation: 0 + 1 = 1, 1 + 1 = 2,
// 2 * 2 = 4, 4 * 2 = 8

// Input:
// N = 7
// Output: 5
// Explanation: 0 + 1 = 1, 1 + 1 = 2,
// 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7

// Dynamic Programming - Bottom Up Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int minOperation(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + Math.min(dp[i / 2], dp[i - 1]);
            } else {
                dp[i] = 1 + dp[i - 1];
            }

        }

        return dp[n];
    }
}

// Greedy Approach
// Time Complexity - O(logn)
class Solution {
    public int minOperation(int n) {
        int res = 0;

        while (n > 0) {
            // If even number divide by 2
            if (n % 2 == 0) {
                n /= 2;
            }
            // If odd number subtract by 1
            else {
                n -= 1;
            }
            res++;
        }

        return res;
    }
}