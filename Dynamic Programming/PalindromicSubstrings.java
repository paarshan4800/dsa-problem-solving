// Given a string s, return the number of palindromic substrings in it.

// A string is a palindrome when it reads the same backward as forward.

// A substring is a contiguous sequence of characters within the string.

// Leetcode - https://leetcode.com/problems/palindromic-substrings/

// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".

// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

// With Dynamic Programming
// Modification of Longest Palindromic Substring
// See solution in LongestPalindromicSubstring.java

// Without Dynamic Programming
// Time Complexity - O(n^2)
// Space Complexity - O(1)
class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            // For odd length palindrom i will be the middle, so start from i,i and trace
            count = tracePalindrome(s, i, i, count);

            // For even length palindrom i and i+1 will be the middle, so start from i,i+1
            // and trace
            count = tracePalindrome(s, i, i + 1, count);
        }

        return count;
    }

    // check palindrome by traversing left and right from the given starting point l
    // and r
    public int tracePalindrome(String s, int l, int r, int count) {
        // If l and r within the bound and both letters are same, increment count and
        // update l and r
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}