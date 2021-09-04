// Given a String S, Find all possible Palindromic partitions of the given
// String.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1/

// Input:
// S = "geeks"
// Output:
// g e e k s
// g ee k s
// Explanation:
// All possible palindromic partitions
// are printed.

// Input:
// S = "madam"
// Output:
// m a d a m
// m ada m
// madam

class Solution {

    // Dynamic Programming - Find all palindromic substrings
    static boolean[][] findPalindromicSubstrings(char[] str) {
        boolean dp[][] = new boolean[str.length][str.length];

        for (int i = 0; i < str.length; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == str[i + 1])
                dp[i][i + 1] = true;
        }

        for (int k = 2; k < str.length; k++) {
            for (int i = 0; i < str.length - k; i++) {
                int j = i + k;
                if (str[i] == str[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp;
    }

    static void findPalindromicSubstrings(String str, int index, ArrayList<String> cur,
            ArrayList<ArrayList<String>> res, boolean[][] dp) {
        // If index == str.length(), then whole string has been traversed. So add cur to
        // result set
        if (index == str.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < str.length(); i++) {
            // If the current partition is a palindrome
            if (dp[index][i]) {
                cur.add(str.substring(index, i + 1)); // Add to set
                findPalindromicSubstrings(str, i + 1, cur, res, dp); // Explore
                cur.remove(cur.size() - 1); // Remove from set (BACKTRACK)
            }
        }
    }

    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        boolean[][] dp = findPalindromicSubstrings(S.toCharArray());

        ArrayList<ArrayList<String>> res = new ArrayList<>();

        findPalindromicSubstrings(S, 0, new ArrayList<>(), res, dp);

        return res;
    }
}