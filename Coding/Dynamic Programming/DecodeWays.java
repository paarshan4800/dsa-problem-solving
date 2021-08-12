// A message containing letters from A-Z can be encoded into numbers using the
// following mapping:

// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"
// To decode an encoded message, all the digits must be grouped then mapped back
// into letters using the reverse of the mapping above (there may be multiple
// ways). For example, "11106" can be mapped into:

// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped
// into 'F' since "6" is different from "06".

// Given a string s containing only digits, return the number of ways to decode
// it.

// The answer is guaranteed to fit in a 32-bit integer.

// Leetcode - https://leetcode.com/problems/decode-ways/

// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2
// 2 6).

// MEMOIZATION
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {

    public int numDecodings(String str, int pos, int[] memo) {
        if (pos >= str.length())
            return 1;

        if (memo[pos] != -1)
            return memo[pos];

        int res = 0;

        // Check for one character
        // Check whether the character forms a valid number (1 to 26)
        if (Integer.parseInt(str.substring(pos, pos + 1)) <= 26 && Integer.parseInt(str.substring(pos, pos + 1)) >= 1) {
            res += numDecodings(str, pos + 1, memo);
        }

        // Check for two characters
        // Check whether there is enought characters to consider 2 chars, the first char
        // of the 2 chars shouldn't be 0 and the character should form a valid number (1
        // to 26)
        if (pos + 1 < str.length() && str.charAt(pos) != '0' && Integer.parseInt(str.substring(pos, pos + 2)) <= 26
                && Integer.parseInt(str.substring(pos, pos + 2)) >= 1) {
            res += numDecodings(str, pos + 2, memo);
        }

        memo[pos] = res;
        return res;
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return numDecodings(s, 0, memo);
    }
}