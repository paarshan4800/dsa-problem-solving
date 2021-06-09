// Given a string s, return the longest palindromic substring in s.

// Leetcode - https://leetcode.com/problems/longest-palindromic-substring/

// Input: s = "babad"
// Output: "bab"

// Input: s = "cbbd"
// Output: "bb"

// Brute force approach
// Generate all possible substrings and check whether they are palindrome or not
// Time Complexity - O(n^3)

// Dynamic Programming - Bottom Up Approach
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        int startIndex = 0;
        int endIndex = 0;
        int size = 1;

        // Diagonals are filled true since all single characters are palindrome
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // Then check for two size strings. Check two characters and if they are same
        // fill true
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                // Update start and end index
                startIndex = i;
                endIndex = i + 1;
                size = 2;
            }
        }

        // Then process strings of size > 2
        for (int k = 2; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                int j = i + k;
                // This subproblem is a palindrome if the first and last characters are same and
                // then string in the middle is a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    // If the size of this substring is greater, update it.
                    if (j - i + 1 > size) {
                        startIndex = i;
                        endIndex = j;
                        size = endIndex - startIndex + 1;
                    }

                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}