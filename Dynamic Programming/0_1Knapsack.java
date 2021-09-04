// You are given weights and values of N items, put these items in a knapsack of
// capacity W to get the maximum total value in the knapsack. Note that we have
// only one quantity of each item.
// In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which
// represent values and weights associated with N items respectively. Also given
// an integer W which represents knapsack capacity, find out the maximum value
// subset of val[] such that sum of the weights of this subset is smaller than
// or equal to W. You cannot break an item, either pick the complete item, or
// don’t pick it (0-1 property).

// Input: N = 3 W = 4 values[] = {1,2,3} weight[] = {4,5,1}
// Output: 3

// Input: N = 3 W = 3 values[] = {1,2,3} weight[] = {4,5,6}
// Output: 0

// Recursive Solution
// Time Complexity - O(2^n)
// Space Complexity - O(n)
class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        return knapSack(W, wt, val, n, 0);
    }

    static int knapSack(int W, int wt[], int val[], int n, int i) {

        // Boundary Condition
        if (i >= n) {
            return 0;
        }

        // If the weight of the item can't fit in the bag (>W), skip it
        if (W < wt[i]) {
            return knapSack(W, wt, val, n, i + 1);
        }

        // Two possibilities (either include or exclude)
        // If we are including, reduce the weight remaining and add the value
        int include = knapSack(W - wt[i], wt, val, n, i + 1) + val[i];
        // If we are excluding, skip it and go to next item
        int exclude = knapSack(W, wt, val, n, i + 1);

        // Return the maximum of these two
        return Math.max(include, exclude);
    }
}

// Top Down Approach - Memoization
// Time Complexity - O(W*n)
// Space Complexity - O(W*n)
class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        // Memoization Table - fill with -1
        int[][] memo = new int[n + 1][W + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        // If weight is 0, profit would be 0
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = 0;
        }

        // If no item is included, profit would be 0
        for (int j = 0; j < memo[0].length; j++) {
            memo[0][j] = 0;
        }

        return knapSack(W, wt, val, n, 1, memo);
    }

    static int knapSack(int W, int wt[], int val[], int n, int i, int[][] memo) {

        if (i > n) {
            return 0;
        }

        if (memo[i][W] != -1) {
            return memo[i][W];
        }

        if (W < wt[i - 1]) {
            memo[i][W] = knapSack(W, wt, val, n, i + 1, memo);
            return memo[i][W];
        }

        int include = knapSack(W - wt[i - 1], wt, val, n, i + 1, memo) + val[i - 1];
        int exclude = knapSack(W, wt, val, n, i + 1, memo);

        memo[i][W] = Math.max(include, exclude);
        return memo[i][W];
    }
}

// Bottum Up Approach
// Time Complexity - O(items*weight)
// Space Complexity - O(items*weight)
class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];

        // If weight is 0, profit would be 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        // If no item is included, profit would be 0
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int item = 1; item <= n; item++) {
            for (int weight = 1; weight <= W; weight++) {

                // If the weight of the item can't fit in the bag (>W), solution to the current
                // subproblem is the solution of previous subproblem (with same weight but
                // current item not included i.e item-1)
                if (weight < wt[item - 1]) {
                    dp[item][weight] = dp[item - 1][weight];
                } else {
                    // Two possibilities (either include or exclude)
                    // If we are including, the solution will be solution of previous subproblem
                    // where weight
                    // is current weight - current item's weight and then add the current item's
                    // value
                    int include = dp[item - 1][weight - wt[item - 1]] + val[item - 1];
                    // If we are excluding, the solution will be the solution of previous subproblem
                    // (with same weight but
                    // current item not included i.e item-1)
                    int exclude = dp[item - 1][weight];

                    // Solution of current sub problem is the maximum of above two
                    dp[item][weight] = Math.max(include, exclude);
                }
            }
        }

        return dp[n][W];
    }

}
