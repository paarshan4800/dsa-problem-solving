// Given a string s, find the length of the longest substring without repeating characters.

// Leetcode - https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Input: s = "abcabcbb"
// Output: 3

// Input: s = "bbbbb"
// Output: 1

// Input: s = "pwwkew"
// Output: 3

// Input: s = ""
// Output: 0

// Brute Force
// Generate All possible substrings and check whether they have repeating characters
// Time Complexity - O(n^3)

// Sliding Window Approach
// Time Complexity - O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        HashSet<Character> hash = new HashSet<>();
        int count = 1; // Initially count will be 0 as we will process 0th element

        int i = 0, j = 1; // i and j are the opening and closing of the current window
        hash.add(s.charAt(i)); // Add the 0th element to the hash set

        // Traverse string using iterator j
        for (; j < s.length(); j++) {
            // If char is not in the hash set, keep expanding the window
            if (!hash.contains(s.charAt(j))) {
                hash.add(s.charAt(j));
                continue;
            }

            // Else, calculate the size of the window (j-i) and update count
            count = Math.max(count, j - i);

            // Keep closing the window till we find the repeating character
            while (s.charAt(i) != s.charAt(j)) {
                hash.remove(s.charAt(i));
                i++;
            }
            i++;

        }

        count = Math.max(count, j - i);
        return count;
    }
}

