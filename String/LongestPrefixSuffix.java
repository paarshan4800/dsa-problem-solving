// Given a string of characters, find the length of the longest proper prefix
// which is also a proper suffix.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1/

// Input: s = "abab"
// Output: 2
// Explanation: "ab" is the longest proper
// prefix and suffix.

// Input: s = "aaaa"
// Output: 3
// Explanation: "aaa" is the longest proper
// prefix and suffix.

// Naive Approach - Time Limit Exceeded
// Time Complexity - O(n^2)
class Solution {
    int lps(String s) {
        int res = 0;
        // Compare prefixes and suffixes of length 1..n-1
        for (int i = 0; i < s.length() - 1; i++) {
            String pre = s.substring(0, i + 1);
            String suf = s.substring(s.length() - i - 1, s.length());
            if (pre.compareTo(suf) == 0)
                res = Math.max(res, i + 1);
        }

        return res;
    }
}

// Efficient Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    int lps(String s) {

        int lpsArr[] = new int[s.length()];
        lpsArr[0] = 0;

        int i = 0, j = 1;

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                lpsArr[j] = i + 1;
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = lpsArr[i - 1];
                } else {
                    lpsArr[j] = i;
                    j++;
                }
            }

        }

        return lpsArr[s.length() - 1];
    }
}