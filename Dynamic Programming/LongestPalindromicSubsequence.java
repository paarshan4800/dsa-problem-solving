// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by
// deleting some or no elements without changing the order of the remaining
// elements.

// Leetcode - https://leetcode.com/problems/longest-palindromic-subsequence/

// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".

class Solution {
    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        // All Strings of length 1 are palindrome itself
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // For strings of length 2,
        // If the two characters are equal, they contribute to a result of 2
        // Else either one of them contributes result of 1
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 1;
            }
        }

        // For strings of length 3 and more
        // If the first and last characters are same, the result will be 2 (first and
        // last char) + result(excluding those two characters)
        // Else result will be max of either excluding first char or excluding last char
        for (int k = 2; k <= s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                int j = i + k;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][s.length() - 1];

    }
}