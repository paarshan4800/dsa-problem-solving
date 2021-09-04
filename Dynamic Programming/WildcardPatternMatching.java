// Given two strings 'str' and a wildcard pattern 'pattern' of length N and M
// respectively, You have to print '1' if the wildcard pattern is matched with
// str else print '0' .

// The wildcard pattern can include the characters ‘?’ and ‘*’
// ‘?’ – matches any single character
// ‘*’ – Matches any sequence of characters (including the empty sequence)

// Note: The matching should cover the entire str (not partial str).

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1/

// YT - https://www.youtube.com/watch?v=NbgUZAoIz3g

// Input:
// pattern = "ba*a?"
// str = "baaabab"
// Output: 1
// Explanation: replace '*' with "aab" and
// '?' with 'b'.

// Input:
// pattern = "a*ab"
// str = "baaabab"
// Output: 0
// Explanation: Because of'a' at first position,
// pattern and str can't be matched.

class Solution {
    int wildCard(String pattern, String str) {
        int patLen = pattern.length();
        int strLen = str.length();

        boolean[][] dp = new boolean[patLen + 1][strLen + 1];

        // Start processing from the end. Extra +1 is for empty case.

        // An empty pattern would match an empty string. So true
        dp[patLen][strLen] = true;

        // For empty string
        for (int i = patLen - 1; i >= 0; i--) {
            // If pattern is *, it can only be empty (it cant be many characters since we
            // are considering empty string)
            if (pattern.charAt(i) == '*')
                dp[i][strLen] = dp[i + 1][strLen];
            // If the pattern is not *, then all other patterns require some string to
            // match. So false
            else
                dp[i][strLen] = false;
        }

        // For empty pattern
        for (int j = strLen - 1; j >= 0; j--)
            // An empty pattern cant match any string other than empty. So false
            dp[0][j] = false;

        for (int i = patLen - 1; i >= 0; i--) {
            for (int j = strLen - 1; j >= 0; j--) {
                // If not a * and ?
                if (pattern.charAt(i) != '*' && pattern.charAt(i) != '?') {
                    // If same char, the result would be the subproblem excluding these two
                    // characters i.e dp[i+1][j+1]
                    if (pattern.charAt(i) == str.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    // If not the same char, then result is false
                    else {
                        dp[i][j] = false;
                    }
                }
                // If pattern is *, it can be empty or many characters
                else if (pattern.charAt(i) == '*') {
                    // If any one of the following is true, then this subproblem is also true
                    // dp[i+1][j] --> empty char
                    // dp[i][j+1] --> one or many char
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                }
                // If pattern is ?, it can be any single character. the result would be the
                // subproblem excluding these two characters i.e dp[i+1][j+1]
                else if (pattern.charAt(i) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0] ? 1 : 0;
    }
}
