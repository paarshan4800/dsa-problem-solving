// Given a set of N items, each with a weight and a value, and a weight limit W.
// Find the maximum value of a collection containing any of the N items any
// number of times so that the total weight is less than or equal to W.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1/

// Input: N = 4, W = 8
// val[] = {1, 4, 5, 7}
// wt[] = {1, 3, 4, 5}
// Output: 11
// Explaination: The optimal choice is to
// pick the 2nd and 4th element.

class Solution {
    static int knapSack(int N, int W, int val[], int wt[]) {

        // 1D array enough as we have all the items at our disposal
        int[] dp = new int[W + 1];

        for (int w = 0; w <= W; w++) {
            for (int i = 0; i < N; i++) {
                // If weight of current item is greater than current weight, skip
                if (wt[i] > w)
                    continue;

                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }

        return dp[W];
    }
}