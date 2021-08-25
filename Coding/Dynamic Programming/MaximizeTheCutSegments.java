// Given an integer N denoting the Length of a line segment. You need to cut the
// line segment in such a way that the cut length of a line segment each time is
// either x , y or z. Here x, y, and z are integers.
// After performing all the cut operations, your total number of cut segments
// must be maximum.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/cutted-segments1642/1/

// Input:
// N = 4
// x = 2, y = 1, z = 1
// Output: 4
// Explanation:Total length is 4, and the cut
// lengths are 2, 1 and 1. We can make
// maximum 4 segments each of length 1.

// Input:
// N = 5
// x = 5, y = 3, z = 2
// Output: 2
// Explanation: Here total length is 5, and
// the cut lengths are 5, 3 and 2. We can
// make two segments of lengths 3 and 2.

// Recursion - Time Limit Exceeded

class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        // If reaches 0, return 0
        if (n == 0)
            return 0;

        // If reaches < 0, the path not possible. Return negative
        if (n < 0)
            return -1;

        // If cut by X
        int cutByX = maximizeCuts(n - x, x, y, z);

        // If cut by Y
        int cutByY = maximizeCuts(n - y, x, y, z);

        // If cut by Z
        int cutByZ = maximizeCuts(n - z, x, y, z);

        // Doing the max will ignore the negative (if any)
        int maxCut = Math.max(cutByX, Math.max(cutByY, cutByZ));

        return 1 + maxCut;
    }
}

// Memoization
class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z, int[] memo) {
        if (n == 0)
            return 0;

        if (n < 0)
            return -1;

        if (memo[n] != Integer.MIN_VALUE)
            return memo[n];

        int cutByX = maximizeCuts(n - x, x, y, z, memo);
        int cutByY = maximizeCuts(n - y, x, y, z, memo);
        int cutByZ = maximizeCuts(n - z, x, y, z, memo);

        int maxCut = Math.max(cutByX, Math.max(cutByY, cutByZ));

        // If maxCut -1, then there is no possible path down, so solution is -1 for this
        // subproblem of n
        memo[n] = maxCut < 0 ? -1 : 1 + maxCut;

        return memo[n];
    }

    public int maximizeCuts(int n, int x, int y, int z) {
        int[] memo = new int[n + 1];

        Arrays.fill(memo, Integer.MIN_VALUE);

        int res = maximizeCuts(n, x, y, z, memo);

        return res < 0 ? 0 : res;
    }
}

// Bottom Up Approach
class Solution {

    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int cutByX = (i - x >= 0) ? dp[i - x] : -1;
            int cutByY = (i - y >= 0) ? dp[i - y] : -1;
            int cutByZ = (i - z >= 0) ? dp[i - z] : -1;

            int maxCut = Math.max(cutByX, Math.max(cutByY, cutByZ));

            dp[i] = maxCut < 0 ? -1 : 1 + maxCut;
        }

        return dp[n] < 0 ? 0 : dp[n];
    }
}
