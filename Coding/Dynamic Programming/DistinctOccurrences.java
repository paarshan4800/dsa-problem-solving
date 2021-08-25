// Given two strings S and T of length n and m respectively. find count of
// distinct occurrences of T in S as a sub-sequence.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/distinct-occurrences/1/

// Input:
// S = "banana" , T = "ban"
// Output: 3
// Explanation: There are 3 sub-sequences:
// [ban], [ba n], [b an].

// Input:
// S = "geeksforgeeks" , T = "ge"
// Output: 6
// Explanation: There are 6 sub-sequences:
// [ge], [ ge], [g e], [g e] [g e] and [ g e].

// Recursion - Time Limit Exceeded
class Solution {

    int subsequenceCount(String S, String T, int s, int t) {

        // If T is traversed completely, then this forms a subsequence. Return 1
        if (t == T.length())
            return 1;

        // If S is traversed completely, then this path doesn't yield a subsequence.
        // Return 0
        if (s == S.length())
            return 0;

        int res = 0;

        // If characters match
        if (S.charAt(s) == T.charAt(t))
            res += subsequenceCount(S, T, s + 1, t + 1);

        // Move String S forward. Check for any other subsequence
        res += subsequenceCount(S, T, s + 1, t);

        return res;
    }

    int subsequenceCount(String S, String T) {
        return subsequenceCount(S, T, 0, 0);
    }
}

// Memoization
class Solution {

    int subsequenceCount(String S, String T, int s, int t, int[][] memo) {
        if (t == T.length())
            return 1;

        if (s == S.length())
            return 0;

        if (memo[s][t] != -1)
            return memo[s][t];

        int res = 0;

        if (S.charAt(s) == T.charAt(t))
            res = (res + subsequenceCount(S, T, s + 1, t + 1, memo)) % 1000000007;

        res = (res + subsequenceCount(S, T, s + 1, t, memo)) % 1000000007;

        memo[s][t] = res;

        return res;
    }

    int subsequenceCount(String S, String T) {
        int memo[][] = new int[S.length() + 1][T.length() + 1];

        for (int[] arr : memo)
            Arrays.fill(arr, -1);

        return subsequenceCount(S, T, 0, 0, memo);
    }
}

// Bottom Up Approach
class Solution {

    int subsequenceCount(String S, String T) {
        int dp[][] = new int[T.length() + 1][S.length() + 1];

        // If T is empty, T with any string S forms a subsequence
        for (int col = 0; col <= S.length(); col++)
            dp[0][col] = 1;

        for (int row = 1; row <= T.length(); row++) {
            for (int col = 1; col <= S.length(); col++) {
                // If characters match, the answer for this subproblem would be the sum of
                // subproblem excluding these two characters and the subproblem excluding the
                // current character of S
                if (S.charAt(col - 1) == T.charAt(row - 1))
                    dp[row][col] = (dp[row - 1][col - 1] + dp[row][col - 1]) % 1000000007;
                // If characters dont match, the answer for this subproblem would be the
                // subproblem excluding the current
                // character of S
                else
                    dp[row][col] = (dp[row][col - 1]) % 1000000007;
            }
        }

        return dp[T.length()][S.length()];
    }
}