// Given two strings s and t of lengths m and n respectively, return the minimum
// window substring of s such that every character in t (including duplicates)
// is included in the window. If there is no such substring, return the empty
// string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.

// Leetcode - https://leetcode.com/problems/minimum-window-substring/

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
// from string t.

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
// from string t.

// SLIDING WINDOW APPROACH
// Time Complexity - O(n)
// Space Complexity - O(n)

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hash = new HashMap<>();

        // store frequency of characters in hash
        for (Character c : t.toCharArray()) {
            if (hash.containsKey(c))
                hash.put(c, hash.get(c) + 1);
            else
                hash.put(c, 1);
        }

        // When counter == 0, it tells that the current window is a valid substring
        // Initially counter is set to length of t
        int start = 0, end = 0, counter = t.length(), minLen = Integer.MAX_VALUE, resStart = 0;

        while (end < s.length()) {
            char cur = s.charAt(end);
            // If s[end] is not in the hash, just continue

            // If s[end] is in the hash
            if (hash.containsKey(cur)) {
                // Decrement its frequency in hash
                hash.put(cur, hash.get(cur) - 1);
                // If frequency of s[end] >= 0, s[end] is part of the string t. So we still need
                // to process counter-1 times. So decrement counter
                if (hash.get(cur) >= 0) {
                    counter--;
                }

                // If counter == 0, it tells that the current window is a valid substring
                // Now start reducing the window by moving start forward till the current window
                // is not a valid substring.
                while (counter == 0) {
                    // In each step, we update the minLen and resStart so
                    // that the result minimum window substring can be found
                    if (end + 1 - start < minLen) {
                        minLen = end + 1 - start;
                        resStart = start;
                    }

                    char temp = s.charAt(start);

                    // If s[start] is not in the hash, just skip. Removing that from the window
                    // still makes the window a valid substring

                    // If s[start] is in the hash, increment its frequency in the hash.
                    if (hash.containsKey(temp)) {
                        hash.put(temp, hash.get(temp) + 1);

                        // If frequency of s[start] > 0, we increment counter by 1
                        // A current window is a valid substring only when all the elements in the hash
                        // have a frequency of 0
                        if (hash.get(temp) > 0)
                            counter++;
                    }

                    start++;
                }
            }
            end++;
        }

        // If minLen == INT_MAX, it means no substring is there.
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resStart, resStart + minLen);
    }
}