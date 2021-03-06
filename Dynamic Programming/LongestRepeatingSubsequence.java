// Given a string, find the length of the longest repeating subsequence such
// that the two subsequences don't have same string character at the same
// position, i.e., any i'th character in the two subsequences shouldn't have the
// same index in the original string.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1#

// Input: str = "axxxy"
// Output: 2
// Explanation: The longest repeating subsequenece
// is "xx".

// Input: str = "aabebcdd"
// Output: 3
// Explanation: The longest repeating subsequenece
// is "abd".

class Solution {

    // LRS = LCS with the condition i!=j

    public int LongestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];
    }
}