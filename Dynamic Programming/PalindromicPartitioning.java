// Given a string str, a partitioning of the string is a palindrome partitioning
// if every sub-string of the partition is a palindrome. Determine the fewest
// cuts needed for palindrome partitioning of given string.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1/

// Input: str = "ababbbabbababa"
// Output: 3
// Explaination: After 3 partitioning substrings
// are "a", "babbbab", "b", "ababa".

// Input: str = "abccbc"
// Output: 2
// Explaination: After 2 partitioning substrings
// are "a", "bccb", "c".

// Time Complexity - O(n^3)

class Solution {

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

    static int palindromicPartition(String str) {

        // Find the palindromic substrings
        boolean[][] lps = findPalindromicSubstrings(str.toCharArray());

        int[][] dp = new int[str.length()][str.length()];

        // For all strings of length 1, they are palindromes. So no cut needed. The
        // answer will be 0
        for (int i = 0; i < str.length(); i++)
            dp[i][i] = 0;

        // For all strings of length 2, if they are palindromes, the answer is 0. Else
        // one cut is needed
        for (int i = 0; i < str.length() - 1; i++) {
            dp[i][i + 1] = lps[i][i + 1] ? 0 : 1;
        }

        // For all strings of length > 2
        for (int k = 2; k < str.length(); k++) {
            for (int i = 0; i < str.length() - k; i++) {
                int j = i + k;

                // If string i to j is a palindrome, then answer is 0
                if (lps[i][j])
                    dp[i][j] = 0;

                // If not a palindrome, we need to cut
                else {
                    // Say i=0 and j=3. Check for cuts (0,0)(1,3) , (0,1)(2,3) , (0,2)(3,3)
                    // Choose the minimum out of these
                    int start = i, end = j;

                    int temp = Integer.MAX_VALUE;

                    for (int c = i; c < j; c++) {
                        temp = Math.min(temp, 1 + dp[start][c] + dp[c + 1][end]);
                    }

                    dp[i][j] = temp;
                }
            }
        }

        return dp[0][str.length() - 1];
    }
}