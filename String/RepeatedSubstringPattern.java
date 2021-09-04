// Given a string s, check if it can be constructed by taking a substring of it
// and appending multiple copies of the substring together.

// Leetcode - https://leetcode.com/problems/repeated-substring-pattern/

// Input: s = "abab"
// Output: true
// Explanation: It is the substring "ab" twice.

// Input: s = "aba"
// Output: false

// Input: s = "abcabcabcabc"
// Output: true
// Explanation: It is the substring "abc" four times or the substring "abcabc"
// twice

class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int strLength = s.length();
        // Start from i = strLen/2 because. The string might be build with two times the
        // substring.
        for (int i = strLength / 2; i >= 1; i--) {
            // strLen should be divisible by i
            if (strLength % i != 0)
                continue;

            // stLen/i gives the number of times the substring can be appended to form the
            // length of given string
            int times = strLength / i;

            // Append the string strLen/i times
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < times; j++) {
                temp.append(s.substring(0, i));
            }

            // If temp == given string, return true
            if (temp.toString().equals(s))
                return true;
        }

        return false;

    }
}