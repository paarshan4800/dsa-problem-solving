// Given two string X and Y of length N and M respectively. The task is to find
// the length of the longest subsequence of string X which is a substring in
// sequence Y.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-length-of-longest-subsequence4905/1

// Input:
// N = 4, M = 8
// X = "abcd"
// Y = "bacdbdcd"
// Output: 3
// Explanation: "acd" is the longest subsequence
// from string X present as a
// substring in string Y.

// RECURSION
// Time Complexity - O(n*m)
class Solution {

    // Process from the end of the current window
    int maxSubsequenceSubstringUtil(String X, String Y, int i, int j) {
        // Base condition
        if (i < 0 || j < 0)
            return 0;

        // If both characters are equal, move the iterators of both X and Y backwards
        if (X.charAt(i) == Y.charAt(j))
            return 1 + maxSubsequenceSubstringUtil(X, Y, i - 1, j - 1);
        // If both characters are not equal, move the iterator of X (subsequence) only
        // because Y should be substring
        else
            return maxSubsequenceSubstringUtil(X, Y, i - 1, j);
    }

    int maxSubsequenceSubstring(String X, String Y, int N, int M) {
        int res = 0;

        // Iteration 1 --> X = abcd , Y = b
        // Iteration 2 --> X = abcd , Y = ba
        // Iteration 3 --> X = abcd , Y = bac
        // Iteration 4 --> X = abcd , Y = bacd
        // and so on
        for (int i = 0; i < Y.length(); i++) {
            res = Math.max(res, maxSubsequenceSubstringUtil(X, Y, X.length() - 1, i));
        }

        return res;
    }
}

// MEMOIZATION
class Solution {

    int maxSubsequenceSubstringUtil(String X, String Y, int i, int j, int[][] memo) {
        if (i < 0 || j < 0)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (X.charAt(i) == Y.charAt(j))
            memo[i][j] = 1 + maxSubsequenceSubstringUtil(X, Y, i - 1, j - 1, memo);
        else
            memo[i][j] = maxSubsequenceSubstringUtil(X, Y, i - 1, j, memo);

        return memo[i][j];
    }

    int maxSubsequenceSubstring(String X, String Y, int N, int M) {
        int[][] memo = new int[X.length()][Y.length()];
        for (int[] arr : memo)
            Arrays.fill(arr, -1);

        int res = 0;
        for (int i = 0; i < Y.length(); i++) {
            res = Math.max(res, maxSubsequenceSubstringUtil(X, Y, X.length() - 1, i, memo));
        }

        return res;
    }
}