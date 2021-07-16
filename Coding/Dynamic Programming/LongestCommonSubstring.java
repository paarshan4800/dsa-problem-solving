// Given two strings. The task is to find the length of the longest common substring.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#

// Input: S1 = "ABCDGH", S2 = "ACDGHR"
// Output: 4
// Explanation: The longest common substring
// is "CDGH" which has length 4.

// Brute Force
// Generate all substrings of S1 and S2 which takes O(n^2) each.
// Compare those substrings which takes O(n^4)

// Dynamic Programming - Bottom up approach
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)
class Solution {
    int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;

        // S1 -> row and S2 -> column

        // If S1 is empty, then res is 0 no matter what S2 is
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // If S2 is empty, then res is 0 no matter what S1 is
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If s1[i-1] == s2[j-1], res is 1 + prev sub problem i.e dp[i-1][j-1] not
                // including the current characters.
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    res = Math.max(res, dp[i][j]); // update res
                }
                // If s1[i-1] == s2[j-1], substring is not possible
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return res;
    }

}