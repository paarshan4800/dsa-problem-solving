// Return the index of the first occurrence of needle in haystack, or -1 if
// needle is not part of haystack.

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/

// Input: haystack = "hello", needle = "ll"
// Output: 2

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1

// Input: haystack = "", needle = ""
// Output: 0

// KMP String Matching Algorithm
// Time Complexity - O(n+m)
// Space Complexity - O(m)

class Solution {

    public int[] computeLPS(String needle) {
        int i = 0, j = 1;
        int[] lps = new int[needle.length()];
        lps[0] = 0;

        while (j < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    j++;
                }
            }
        }

        return lps;
    }

    public int matchPattern(String haystack, String needle, int lps[]) {
        int i = 0, j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {
                return i - j;
            }

            else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        // If needle length is 0
        if (needle.length() == 0) {
            return 0;
        }

        // If haystack length is 0
        if (haystack.length() == 0) {
            return -1;
        }

        int[] lps = computeLPS(needle);
        return matchPattern(haystack, needle, lps);
    }
}