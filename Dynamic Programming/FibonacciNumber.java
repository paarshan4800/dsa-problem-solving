// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
// Fibonacci sequence, such that each number is the sum of the two preceding
// ones, starting from 0 and 1. That is,

// F(0) = 0, F(1) = 1
// F(n) = F(n - 1) + F(n - 2), for n > 1.
// Given n, calculate F(n).

// Leetcode - https://leetcode.com/problems/fibonacci-number/

// Input: n = 4
// Output: 3

// Input: n = 3
// Output: 2

// Recursive Solution
// Time Complexity - O(2^n)
// Space Complexity - O(n)
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}

// Memoization - Top Down Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int fib(int n) {

        if (n < 2) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        return fib(n, memo);
    }

    public int fib(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

}

// Dynamic Programming - Bottom Up Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];

        if (n < 2) {
            return n;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}