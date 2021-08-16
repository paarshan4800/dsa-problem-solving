// You are given N identical eggs and you have access to a K-floored building
// from 1 to K.

// There exists a floor f where 0 <= f <= K such that any egg dropped at a floor
// higher than f will break, and any egg dropped at or below floor f will not
// break. There are few rules given below.

// An egg that survives a fall can be used again.
// A broken egg must be discarded.
// The effect of a fall is the same for all eggs.
// If the egg doesn't break at a certain floor, it will not break at any floor
// below.
// If the eggs breaks at a certain floor, it will break at any floor above.
// Return the minimum number of moves that you need to determine with certainty
// what the value of f is.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1/

// Input:
// N = 1, K = 2
// Output: 2

// Input:
// N = 2, K = 10
// Output: 4

// Recursion - Time Limit Exceeded
// Time Complexity: O(n * (2^min(n,k))
class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int eggs, int floors) {

        // Base Case
        // If 0 or 1 floors, there are only 0 and 1 possibilities respectively
        if (floors == 0 || floors == 1)
            return floors;

        // If there are more than 1 floors and eggs are only 1, we have to atmost drop
        // the egg at each floor. So return floors
        if (eggs == 1)
            return floors;

        int res = Integer.MAX_VALUE;

        // Simulate for each floor
        for (int floor = 1; floor <= floors; floor++) {
            // 1 + eggDrop(eggs - 1, floor - 1) ---> If the egg breaks, number of eggs
            // reduces by one and also we know that floors above the current floor breaks
            // egg. So we go down a floor and check
            // 1 + eggDrop(eggs , floors - floor) ---> If the egg doesnt break, number of
            // eggs remain the same and then we know that the egg doesnt break at floors
            // below. So we go up a floor.
            // We take the maximum because we need to report the worst case
            int attempts = 1 + Math.max(eggDrop(eggs - 1, floor - 1), eggDrop(eggs, floors - floor));

            res = Math.min(res, attempts);
        }

        return res;
    }
}

// Top Down Approach - Memoization

class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.
    static int eggDrop(int eggs, int floors, int[][] memo) {
        if (floors == 0 || floors == 1)
            return floors;

        if (eggs == 1)
            return floors;

        if (memo[eggs][floors] != -1)
            return memo[eggs][floors];

        int res = Integer.MAX_VALUE;

        for (int floor = 1; floor <= floors; floor++) {
            int attempts = 1 + Math.max(eggDrop(eggs - 1, floor - 1, memo), eggDrop(eggs, floors - floor, memo));

            res = Math.min(res, attempts);
        }

        memo[eggs][floors] = res;
        return res;
    }

    static int eggDrop(int eggs, int floors) {
        int[][] memo = new int[eggs + 1][floors + 1];

        for (int[] row : memo)
            Arrays.fill(row, -1);

        return eggDrop(eggs, floors, memo);
    }
}

// Bottom Up Approach - TABULATION

class Solution {
    // Function to find minimum number of attempts needed in
    // order to find the critical floor.

    static int eggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];

        // One egg
        for (int floor = 0; floor <= floors; floor++)
            dp[1][floor] = floor;

        // One floor
        for (int egg = 1; egg <= eggs; egg++)
            dp[egg][1] = 1;

        for (int egg = 2; egg <= eggs; egg++) {
            for (int floor = 2; floor <= floors; floor++) {

                dp[egg][floor] = Integer.MAX_VALUE;
                for (int f = 1; f <= floor; f++) {
                    int attempts = 1 + Math.max(dp[egg - 1][f - 1], dp[egg][floor - f]);

                    dp[egg][floor] = Math.min(dp[egg][floor], attempts);
                }

            }
        }

        return dp[eggs][floors];
    }
}