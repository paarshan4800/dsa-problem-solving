// You are given a binary string s. You are allowed to perform two types of
// operations on the string in any sequence:

// Type-1: Remove the character at the start of the string s and append it to
// the end of the string.
// Type-2: Pick any character in s and flip its value, i.e., if its value is '0'
// it becomes '1' and vice-versa.
// Return the minimum number of type-2 operations you need to perform such that
// s becomes alternating.

// The string is called alternating if no two adjacent characters are equal.

// For example, the strings "010" and "1010" are alternating, while the string
// "0100" is not.

// Leetcode -
// https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/

// YT - https://www.youtube.com/watch?v=MOeuK6gaC2A

// Input: s = "111000"
// Output: 2
// Explanation: Use the first operation two times to make s = "100011".
// Then, use the second operation on the third and sixth elements to make s =
// "101010".

class Solution {
    public int minFlips(String s) {
        int n = s.length();

        s += s;

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                str1.append("0");
                str2.append("1");
            } else {
                str1.append("1");
                str2.append("0");
            }
        }

        int l = 0;

        int res = Integer.MAX_VALUE, diff1 = 0, diff2 = 0;

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) != str1.charAt(r))
                diff1++;
            if (s.charAt(r) != str2.charAt(r))
                diff2++;

            // If window size > n, reduce window size by moving left forward
            if (r - l + 1 > n) {

                // Update diff1 and diff2 if necessary
                if (s.charAt(l) != str1.charAt(l))
                    diff1--;
                if (s.charAt(l) != str2.charAt(l))
                    diff2--;

                l++;
            }

            // If window size == n, Update res
            if (r - l + 1 == n)
                res = Math.min(res, Math.min(diff1, diff2));

        }

        return res;

    }
}