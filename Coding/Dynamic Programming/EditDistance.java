// Given two strings s and t. Find the minimum number of operations that need to
// be performed on str1 to convert it to str2. The possible operations are:

// Insert
// Remove
// Replace

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/edit-distance3702/1#

// Input: str1 = "sunday", str2 = "saturday"
// Output: 3
// Last three and first characters are same. We basically
// need to convert "un" to "atur". This can be done using
// below three operations.
// Replace 'n' with 'r', insert t, insert a

// Bottom up Approach - DP
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)

class Solution {
    public int editDistance(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        // For all subproblems where str2 is "" and str1 is "a","ab","abc" and so on
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = i;

        // For all subproblems where str1 is "" and str2 is "a","ab","abc" and so on
        for (int i = 0; i <= t.length(); i++)
            dp[0][i] = i;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                // If last characters of current window match, then the result is the subproblem
                // ignoring the current characters i.e dp[i-1][j-1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the last characters dont match, we have to do atleast one operation
                // (delete/insert/replace). So we add 1 to the minimum of delete/insert/replace
                // If dp[i][j] = 1 + dp[i][j-1] --> DELETE : result is the subproblem ignoring
                // the last character in str2
                // If dp[i][j] = 1 + dp[i-1][j-1] --> REPLACE : result is the subproblem
                // ignoring the last character in str1 and str2
                // If dp[i][j] = 1 + dp[i-1][j] --> INSERT : result is the subproblem ignoring
                // the last character in str1
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}