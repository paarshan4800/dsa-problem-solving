// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Leetcode - https://leetcode.com/problems/climbing-stairs/
// YT - https://www.youtube.com/watch?v=NFJ3m9a1oJQ

// Input: n = 2
// Output: 2

// Input: n = 3
// Output: 3

// Input: n = 4
// Output: 5

// Recursive Solution (Not Accepted - Time limit exceeded)
// Top Down Approach
// Time Complexity - O(2^n)
// Space Complexity - O(n)
class Solution {

    public int climbStairs(int n) {

        // Base condition
        // If n<0, this sub problem yields no solution
        if (n < 0) {
            return 0;
        }

        // If n=0, this sub problem yields 1
        if (n == 0) {
            return 1;
        }

        // Recur. Can either climb one step or two steps.
        return climbStairs(n - 1) + climbStairs(n - 2);

    }
}

// Memoization (Top Down Approach)
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {

    public int climbStairs(int dp[], int n) {

        // If this subproblem n is already calculated, return the answer
        if (dp[n] != -1) {
            return dp[n];
        }

        // Base condition
        // If n<0, this sub problem yields no solution
        if (n < 0) {
            return 0;
        }

        // Calculate result if one step is taken
        // If this subproblem n-1 is already calculated, return the answer. Else recur
        int oneStep = (dp[n - 1] != -1) ? dp[n - 1] : climbStairs(dp, n - 1);

        // Calculate result if two steps are taken
        // If this subproblem n-2 is already calculated, return the answer. Else recur
        int twoSteps = (dp[n - 2] != -1) ? dp[n - 2] : climbStairs(dp, n - 2);

        // Store the result to the DP table and return.
        dp[n] = oneStep + twoSteps;
        return dp[n];
    }

    public int climbStairs(int n) {

        // Memoization for Top Down approach. Set all values to -1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Intial subproblems. For n=1 and n=0, answer is 1
        dp[0] = 1;
        dp[1] = 1;

        return climbStairs(dp, n);

    }
}

// Dynamic Programming - Bottum Up Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int climbStairs(int n) {

        // Tabulation for Bottom Up approach. By default, all set to 0
        int[] dp = new int[n + 1];

        // Intial subproblems. For n=1 and n=0, answer is 1
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}

// Just the fibonacci sequence