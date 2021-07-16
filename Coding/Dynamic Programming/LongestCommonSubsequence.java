// Given two sequences, find the length of longest subsequence present in both
// of them. Both the strings are of uppercase.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#

// Input:
// A = 6, B = 6
// str1 = ABCDGH
// str2 = AEDFHR
// Output: 3

// Input:
// A = 5, B = 7
// str1 = stone
// str2 = longest
// Output: 3

// Recursive Approach
// Time Complexity - O(2^n)
class Solution {
    static int lcsRec(int i, int j, String s1, String s2) {
        // Base condition
        // If any one of the string is traversed completely, return 0
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // If s[i] == s[j], it yields 1 to the res. So move to next character by
        // returning 1 + rec(i+1,j+1)
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + lcsRec(i + 1, j + 1, s1, s2);
        // If s[i] != s[j], take the maximum of two possibilities
        // i) fixing i and moving j to next character
        // ii) fixing j and moving i to next character
        else
            return Math.max(lcsRec(i, j + 1, s1, s2), lcsRec(i + 1, j, s1, s2));
    }

    static int lcs(int x, int y, String s1, String s2) {
        return lcsRec(0, 0, s1, s2);
    }

}

// Top Down Approach - Memoization
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
class Solution {
    static int lcsRec(int i, int j, String s1, String s2, int[][] memo) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] == -1) {

            if (s1.charAt(i) == s2.charAt(j))
                memo[i][j] = 1 + lcsRec(i + 1, j + 1, s1, s2, memo);
            else
                memo[i][j] = Math.max(lcsRec(i, j + 1, s1, s2, memo), lcsRec(i + 1, j, s1, s2, memo));

        }

        return memo[i][j];
    }

    static int lcs(int x, int y, String s1, String s2) {
        int[][] memo = new int[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(memo[i], -1);
        }
        return lcsRec(0, 0, s1, s2, memo);
    }

}

// Bottom Up Approach
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)
class Solution {
    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[x + 1][y + 1];

        // S1 -> row and S2 -> column

        // If S1 is empty, then res is 0 no matter what S2 is
        for (int i = 0; i <= y; i++) {
            dp[0][i] = 0;
        }

        // If S2 is empty, then res is 0 no matter what S1 is
        for (int i = 0; i <= x; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                // If s1[i-1] == s2[j-1], this yields 1 to the res. So res is 1 + prev
                // subproblem i.e dp[i-1][j-1] without including current characters
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // If s1[i-1] != s2[j-1], take the max of two subproblems
                // i) Not including i, i.e dp[i-1][j]
                // ii) Not including j, i.e dp[i][j-1]
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[x][y];
    }

}